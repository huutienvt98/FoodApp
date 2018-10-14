package com.example.dell.foodapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {
    TextView textView2;
    TextView textView3;
    TextView textView1;
    TextView textView0;
    TextView textView4;
    TextView textView5;
    ImageView imageView0;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView0 = (TextView)findViewById(R.id.textView0);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);
        imageView0 = findViewById(R.id.imageView0);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String label = bundle.getString("label");
        String url = bundle.getString("url");
        String imgUrl = bundle.getString("image url");

        String[] labelArray = label.split(";");
        final String[] urlArray = url.split(";");
        String[] imgUrlArray = imgUrl.split(";");

        if (labelArray == null) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

        Log.i("lul", labelArray[0]);
        textView0.setText(labelArray[0]);
        textView1.setText(labelArray[1]);
        textView2.setText(labelArray[2]);
        textView3.setText(labelArray[3]);
        textView4.setText(labelArray[4]);
        textView5.setText(labelArray[5]);
        Picasso.get().load(imgUrlArray[0]).into(imageView0);
        Picasso.get().load(imgUrlArray[1]).into(imageView1);
        Picasso.get().load(imgUrlArray[2]).into(imageView2);
        Picasso.get().load(imgUrlArray[3]).into(imageView3);
        Picasso.get().load(imgUrlArray[4]).into(imageView4);
        Picasso.get().load(imgUrlArray[5]).into(imageView5);
        //Prayyyyy
        imageView0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(urlArray[0]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(urlArray[1]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(urlArray[2]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(urlArray[3]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(urlArray[4]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse(urlArray[5]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}
