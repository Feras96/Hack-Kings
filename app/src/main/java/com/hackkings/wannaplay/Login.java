package com.hackkings.wannaplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText usernameField;
    private EditText passwordField;

    public void signUpOrLogin(View view) {

        Log.i("AppInfo", String.valueOf(usernameField.getText()));
        Log.i("AppInfo", String.valueOf(passwordField.getText()));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameField = (EditText) findViewById(R.id.username);
        passwordField = (EditText) findViewById(R.id.password);
    }
}
