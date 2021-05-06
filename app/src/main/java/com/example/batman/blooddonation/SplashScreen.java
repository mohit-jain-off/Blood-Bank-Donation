
package com.example.batman.blooddonation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_splash_screen);
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {

                    sleep(3000);
                    SplashScreen splashScreen=SplashScreen.this;
                    splashScreen.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            requestNewInterstitial();
                        }
                    });

                }
                catch (Exception e)
                {

                }
            }
        };
        thread.start();
    }

    private void requestNewInterstitial() {
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
    }

