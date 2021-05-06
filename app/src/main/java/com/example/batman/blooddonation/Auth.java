package com.example.batman.blooddonation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Auth extends AppCompatActivity {
EditText pin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        pin=(EditText)findViewById(R.id.pin);
        Button b=(Button)findViewById(R.id.go);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pin.getText().toString().equals("2017"));{
                Intent intent=new Intent(getApplicationContext(),AdminActivity.class);
                startActivity(intent);}
            }
        });

    }
}
