package com.example.batman.blooddonation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionsPage extends AppCompatActivity {
Button donor,inneed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_page);
        donor=(Button)findViewById(R.id.donor);
        inneed=(Button)findViewById(R.id.inneed);
        donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),DonorActivity.class);
                startActivity(i);
            }
        });
        inneed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(getApplicationContext(),RequestBlood.class);
                startActivity(i2);
            }
        });

    }
}
