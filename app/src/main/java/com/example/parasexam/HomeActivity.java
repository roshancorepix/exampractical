package com.example.parasexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tv_fruit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv_fruit = findViewById(R.id.tv_fruit);

        Intent i = getIntent();
        tv_fruit.setText(i.getStringExtra("fruit"));
    }
}