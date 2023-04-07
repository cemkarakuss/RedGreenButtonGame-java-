package com.cemkarakus.redgreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AnaEkran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);
    }

    public void mainMenuStart (View view){

        Intent intent = new Intent(AnaEkran.this,MainActivity.class);
        startActivity(intent);

    }

    public void mainMenuSettings (View view){

    }
}