package com.example.batman.blooddonation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends Fragment {
    Button b;
    EditText t1,t2;
    private FirebaseAuth mAuth;
    public RegisterActivity() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_register, container, false);
        b=(Button)rootview.findViewById(R.id.button2);
        mAuth = FirebaseAuth.getInstance();
        t1=(EditText)rootview.findViewById(R.id.editText);
        t2=(EditText)rootview.findViewById(R.id.editText4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog= ProgressDialog.show(getContext(),"please wait..","Processing",true);
                (mAuth.createUserWithEmailAndPassword(t1.getText().toString(),t2.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            Snackbar.make(MainActivity.coordinatorLayout, "done", Snackbar.LENGTH_LONG).show();
                        }
                    }
                });
            }  });
        return rootview;
    }
}
