package com.nit.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email,password;

    Button registerButton,loginButton;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.pass);
        registerButton = (Button) findViewById(R.id.registerButton);
        loginButton = (Button) findViewById(R.id.LoginButton);
        firebaseAuth = FirebaseAuth.getInstance();
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String eemail = email.getText().toString();
                String ppassword = password.getText().toString();
                if(TextUtils.isEmpty(eemail)){
                    Toast.makeText(getApplicationContext(),"please fill in the required fields",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ppassword)){
                    Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ppassword.length()<6){

                    Toast.makeText(getApplicationContext(),"Password must be at least 6 characters",Toast.LENGTH_SHORT).show();
                }

                    firebaseAuth.createUserWithEmailAndPassword(eemail,ppassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Email or password is wrong", Toast.LENGTH_SHORT).show();
                                }
                                }
                            });



            }

        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });



    }
}
