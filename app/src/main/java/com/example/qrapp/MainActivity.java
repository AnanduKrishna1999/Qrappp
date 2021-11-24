package com.example.qrapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    Button btscan;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btscan=findViewById(R.id.bt1);
        btscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator= new IntentIntegrator(MainActivity.this);
                intentIntegrator.setPrompt("flash volume up key");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(capture.class);
                intentIntegrator.initiateScan();


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (intentResult.getContents() != null){
            String j=intentResult.getContents();
            sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("content", j);
            editor.commit();
            Intent i =new Intent(getApplicationContext(),showcontent.class);
            startActivity(i);

        }
        else
        {
            Toast.makeText(getApplicationContext(),"oops",Toast.LENGTH_LONG).show();

        }
    }
}