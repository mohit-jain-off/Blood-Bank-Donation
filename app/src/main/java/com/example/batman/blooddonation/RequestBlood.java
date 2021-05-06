package com.example.batman.blooddonation;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RequestBlood extends AppCompatActivity {
    EditText search;
    ArrayList<DonorsDet> details;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    Button review;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_blood);
        details = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("donor_details");
        AsyncTask asyncTask=new AsyncTask();
        asyncTask.execute();
    }


    public class AsyncTask extends android.os.AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        DonorsDet donorsDet = new DonorsDet();
                        donorsDet.setPlace(ds.getValue(DonorsDet.class).getPlace());
                        donorsDet.setName(ds.getValue(DonorsDet.class).getName());
                        donorsDet.setContact(ds.getValue(DonorsDet.class).getContact());
                        details.add(donorsDet);
                    }
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(getApplicationContext(), details);
                    recyclerView.setAdapter(adapter);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(),"try again later",Toast.LENGTH_LONG).show();
                }
            });
            return null;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.admin);
        {
            Intent intent=new Intent(getApplicationContext(),Auth.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}




