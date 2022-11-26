package com.example.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;
    int value;
    Handler handler = new Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress_bar);
        textView = findViewById(R.id.tvPercent);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                startProgress();
            }
        });
        thread.start();

    }

        public void startProgress(){

        for(value = 0; value<100;value = value + 1){

            try{
                Thread.sleep(50);
                progressBar.setProgress(value);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(String.valueOf(value + " %"));
                }
            });

        }




    }


}