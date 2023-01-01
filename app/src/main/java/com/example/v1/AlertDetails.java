package com.example.v1;

import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class AlertDetails extends AppCompatActivity {

    TextView textView, sndTxt;
    Button bt;
    ImageView img1, img2, img3, img4, img5;
    Integer face = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_details);

        textView = (TextView) findViewById(R.id.text_input);
        bt = (Button) findViewById(R.id.button3);
        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        sndTxt = (TextView) findViewById(R.id.textView2);

        findViewById(R.id.imageView1).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View view) {
                textView.setVisibility((View.VISIBLE));
                bt.setVisibility((View.VISIBLE));
                face = 1;
                img1.setImageResource(R.raw.mg_1bg);
                img2.setImageResource(R.raw.mg_2);
                img3.setImageResource(R.raw.mg_3);
                img4.setImageResource(R.raw.mg_4);
                img5.setImageResource(R.raw.mg_5);
                //TODO save locally time, choice and textInput
            }
        });
        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View view) {
                textView.setVisibility((View.VISIBLE));
                bt.setVisibility((View.VISIBLE));
                face = 2;
                img1.setImageResource(R.raw.mg_1);
                img2.setImageResource(R.raw.mg_2bg);
                img3.setImageResource(R.raw.mg_3);
                img4.setImageResource(R.raw.mg_4);
                img5.setImageResource(R.raw.mg_5);

                //TODO save locally time, choice and textInput
            }
        });
        findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View view) {
                textView.setVisibility((View.VISIBLE));
                bt.setVisibility((View.VISIBLE));
                face = 3;
                img1.setImageResource(R.raw.mg_1);
                img2.setImageResource(R.raw.mg_2);
                img3.setImageResource(R.raw.mg_3bg);
                img4.setImageResource(R.raw.mg_4);
                img5.setImageResource(R.raw.mg_5);
                //TODO save locally time, choice and textInput
            }
        });
        findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View view) {
                textView.setVisibility((View.VISIBLE));
                bt.setVisibility((View.VISIBLE));
                face = 4;
                img1.setImageResource(R.raw.mg_1);
                img2.setImageResource(R.raw.mg_2);
                img3.setImageResource(R.raw.mg_3);
                img4.setImageResource(R.raw.mg_4bg);
                img5.setImageResource(R.raw.mg_5);
                //TODO save locally time, choice and textInput
            }
        });
        findViewById(R.id.imageView5).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View view) {
                textView.setVisibility((View.VISIBLE));
                bt.setVisibility((View.VISIBLE));
                face = 5;
                img1.setImageResource(R.raw.mg_1);
                img2.setImageResource(R.raw.mg_2);
                img3.setImageResource(R.raw.mg_3);
                img4.setImageResource(R.raw.mg_4);
                img5.setImageResource(R.raw.mg_5bg);
                //TODO save locally time, choice and textInput
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sndTxt.setVisibility((View.VISIBLE));
                (new Handler()).postDelayed(this::yourMethod, 1000);

                //Intent i = new Intent(AlertDetails.this, MainActivity.class);
                //startActivity(i);
            }

            private void yourMethod() {
                finish();
                System.exit(0);
            }
        });
    }
}