package com.scritian.googlecourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText etUserName;
    private EditText etPassword;
    private String registeredUser= "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=findViewById(R.id.bLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= etUserName.getText().toString();
                String password=etPassword.getText().toString();
                if(password.equals(registeredUser) & username.equals(registeredUser)) {
                    Toast.makeText(LoginActivity.this, "You have succesfully logged in!", Toast.LENGTH_SHORT).show();
                    //setContentView(R.layout.activity_main);
                    startActivity(new Intent(LoginActivity.this, MoviesActivity.class));
                }
                else if(!password.equals(registeredUser) & username.equals(registeredUser))
                    Toast.makeText(LoginActivity.this, "Wrong password!", Toast.LENGTH_SHORT).show();
                else if(password.equals(registeredUser) & !username.equals(registeredUser))
                    Toast.makeText(LoginActivity.this, "Wrong username!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(LoginActivity.this, "Wrong username and password!", Toast.LENGTH_SHORT).show();
                //Log.d(  "Login activity",  "Login Pressed");
            }
        });
        etUserName=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
    }
}
