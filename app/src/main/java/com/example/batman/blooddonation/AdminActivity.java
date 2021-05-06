package com.example.batman.blooddonation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminActivity extends AppCompatActivity {
EditText name1,contact1,location1;
Button sub;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        name1=(EditText)findViewById(R.id.name1);
        contact1=(EditText)findViewById(R.id.contact1);
        location1=(EditText)findViewById(R.id.location1);
        sub=(Button)findViewById(R.id.submit);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("donor_details");
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name1.getText().toString();
                String c=contact1.getText().toString();
                String l=location1.getText().toString();
                DonorsDet donorsDet=new DonorsDet(l,n,c);
                String id=databaseReference.push().getKey();
                databaseReference.child(id).setValue(donorsDet).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"submitted",Toast.LENGTH_LONG).show();
                        Intent i=new Intent(getApplicationContext(),RequestBlood.class);
                        startActivity(i);
                    }
                });

            }
        });

    }
}
