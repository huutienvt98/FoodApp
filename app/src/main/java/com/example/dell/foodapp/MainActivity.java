package com.example.dell.foodapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String labelString = "";
    String urlString = "";
    String imgUrlString = "";
    String ingredientsString = "";

    EditText inputEditText;
    String input;
    public void searchFunction (View view) {
        DownloadTask task = new DownloadTask();
        input = inputEditText.getText().toString();
        task.execute("https://api.edamam.com/search?q=" + input + "&app_id=35da9b7a&app_key=cab4a3eef6d516b0030525ebc5c76cf7%20&from=0&to=10");

    }

    public class DownloadTask extends AsyncTask<String, Void, String> {
        String result = "";
        String rec;
        ArrayList<String> labelList = new ArrayList<>();
        ArrayList<String> urlList = new ArrayList<>();
        ArrayList<String> imgUrlList = new ArrayList<>();
        ArrayList<String> ingredientsList = new ArrayList<>();


        @Override
        protected String doInBackground(String... urls) {
            try {
                String sURL = "https://api.edamam.com/search?q=" + input + "&app_id=35da9b7a&app_key=cab4a3eef6d516b0030525ebc5c76cf7%20&from=0&to=10"; //just a string

                // Connect to the URL using java's native library
                URL url = new URL(sURL);
                URLConnection request = url.openConnection();
                request.connect();

                // Convert to a JSON object to print data
                JsonParser jp = new JsonParser(); //from gson
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
                result = root.toString();
                return result;
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray hitsArray = jsonObject.getJSONArray("hits");

                for(int i = 0 ; i < 10 ; i++){
                    JSONObject p = (JSONObject)hitsArray.get(i);
                    JSONObject base = p.getJSONObject("recipe");
                    labelString += base.getString("label") + ";";
                    urlString += base.getString("url") + ";";
                    imgUrlString += base.getString("image") + ";";
                    ingredientsString += base.getString("ingredientLines") + ";";

                }

                Log.i("Food label", labelString);
                Log.i("Food image URL", imgUrlString);
                Log.i("Recipe URL", urlString);
                Log.i("Recipe ingredients", ingredientsString);
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("label", labelString);
                intent.putExtra("url", urlString);
                intent.putExtra("image url", imgUrlString);
                startActivity(intent);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = findViewById(R.id.inputEditText);

    }
}
