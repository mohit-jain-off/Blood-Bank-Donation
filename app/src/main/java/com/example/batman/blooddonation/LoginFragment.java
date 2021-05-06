package com.example.batman.blooddonation;


import android.app.ProgressDialog;
import android.content.Intent;
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


public class LoginFragment extends Fragment {
    Button b1;
    EditText t,t4;
    private FirebaseAuth firebaseAuth;

    public LoginFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        t=(EditText)view.findViewById(R.id.editText);
        firebaseAuth=FirebaseAuth.getInstance();
        t4=(EditText)view.findViewById(R.id.editText4);
        b1=(Button)view.findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog= ProgressDialog.show(getContext(),"Please wait","processing..",true);
                (firebaseAuth.signInWithEmailAndPassword(t.getText().toString(),t4.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            Toast.makeText(getContext(),"welcome", Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getContext(),OptionsPage.class);
                            startActivity(i);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(MainActivity.coordinatorLayout,"Please Check your login id/password",Snackbar.LENGTH_LONG).show();
                    }
                });
            }
        });



        return view;



    }

}
