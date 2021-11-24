package com.example.qrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class showcontent extends AppCompatActivity {
 TextView ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcontent);

        ct=findViewById(R.id.cont);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPREFERENCES", MODE_PRIVATE);
        String value = sharedPreferences.getString("content","");

        ct.setText(value);
    }
}