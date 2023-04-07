package com.cemkarakus.redgreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView scoreText;
    TextView timeText;
    int score;

    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageViewa;
    ImageView imageView1a;
    ImageView imageView2a;
    ImageView imageView3a;
    ImageView imageView4a;
    ImageView imageView5a;
    ImageView imageView6a;
    ImageView imageView7a;
    ImageView imageView8a;

    ImageView[] imageArray;

    Handler handler;
    Runnable runnable;

    String userScore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreText = findViewById(R.id.scoreText);
        timeText = findViewById(R.id.timeText);
        score = 0;

        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageViewa = findViewById(R.id.imageViewa);
        imageView1a = findViewById(R.id.imageView1a);
        imageView2a = findViewById(R.id.imageView2a);
        imageView3a = findViewById(R.id.imageView3a);
        imageView4a = findViewById(R.id.imageView4a);
        imageView5a = findViewById(R.id.imageView5a);
        imageView6a = findViewById(R.id.imageView6a);
        imageView7a = findViewById(R.id.imageView7a);
        imageView8a = findViewById(R.id.imageView8a);
        userScore = "";

        imageArray = new ImageView[] {imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageViewa,imageView1a,imageView2a,imageView3a,imageView4a,imageView5a,imageView6a,imageView7a,imageView8a};

        makeScore();



        new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time: " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("TimeOFF!");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Intent intent1 = new Intent(MainActivity.this,sonucEkrani.class);
                intent1.putExtra("my_score", score);
                startActivity(intent1);
            }
        }.start();
    }




    public void yesilButtonArtiScore(View view){
        score++;
        scoreText.setText("Score: "+ score);

    }

    public void kirmiziButtonEksiScore (View view){
        score--;
        scoreText.setText("Score: "+ score);
    }


    public void makeScore(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(18);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,400);
            }
        };
            handler.post(runnable);
        }

    }

