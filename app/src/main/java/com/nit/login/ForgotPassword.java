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
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    EditText email;
    Button ResetButton,BackButton;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);
        email = (EditText)findViewById(R.id.forget);
        ResetButton = (Button)findViewById(R.id.LoginButton2);
        BackButton = (Button)findViewById(R.id.BackButton);
        firebaseAuth = FirebaseAuth.getInstance();
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        ResetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String eemail = email.getText().toString();

                if(TextUtils.isEmpty(eemail)){
                    Toast.makeText(getApplicationContext(),"Enter the registered email",Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.sendPasswordResetEmail(eemail)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Link to reset Password has been send to register email id",Toast.LENGTH_SHORT);
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"Failed to reset password",Toast.LENGTH_SHORT);
                                }
                             }
                        });


            }
        });

    }

}
