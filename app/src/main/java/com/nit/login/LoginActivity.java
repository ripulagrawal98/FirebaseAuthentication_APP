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

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    EditText loginEmail,loginPassword;
    Button loginButton,registerButton2,newPassButton;
    private static final int RC_SIGN_IN = 9001;
    private SignInButton signInButton;
    FirebaseAuth firebaseAuth;
    GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        loginEmail = (EditText) findViewById(R.id.Email2);
        loginPassword = (EditText) findViewById(R.id.pass2);
        loginButton = (Button) findViewById(R.id.LoginButton2);
        registerButton2 = (Button) findViewById(R.id.registerButton2);
//        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        newPassButton = (Button) findViewById(R.id.forgetButton);

        firebaseAuth = FirebaseAuth.getInstance();

        newPassButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(),ForgotPassword.class));
            }

        });
        registerButton2.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
    });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String eemail = loginEmail.getText().toString();
                final String ppassword = loginPassword.getText().toString();
                if(TextUtils.isEmpty(eemail)){
                    Toast.makeText(getApplicationContext(),"please fill in the required fields",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ppassword)){
                    Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(eemail, ppassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    startActivity(new Intent(getApplicationContext(),CalenderActivity.class));
                                    finish();
                                }
                                else
                                {

//                                        // there was an error
//                                        if (ppassword.length() < 6) {
//                                            loginPassword.setError("Password too short, enter minimum 6 characters!");
//                                        }
//                                        else {
                                            Toast.makeText(LoginActivity.this, "Authentication failed, check your email and password or sign up", Toast.LENGTH_LONG).show();
                                        }
                                }





                        });

            }
        });



}
}