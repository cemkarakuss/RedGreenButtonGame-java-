package com.cemkarakus.redgreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class sonucEkrani extends AppCompatActivity {

    TextView sonucEkraniScore;
    int myscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc_ekrani);

        sonucEkraniScore = findViewById(R.id.sonucEkraniScore);

        sonucEkraniScore.setText("Score: 0");

        Intent intent = getIntent();
        myscore = intent.getIntExtra("my_score", 0);
        sonucEkraniScore.setText("Score: "+ myscore);

    }

    public void mainMenuTickButton(View view) {
        Intent intent = new Intent(sonucEkrani.this,AnaEkran.class);
        startActivity(intent);

    }

    public void tryAgainTickButton(View view){
        Intent intent = getIntent();
        finish();
        Intent intent1 = new Intent(sonucEkrani.this,MainActivity.class);
        startActivity(intent1);

    }

}