package com.example.shreyasingh.firebaseemaillogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //views and widget fields
    Button createUser, moveToLogin;
    EditText userEmailEdit, userpassWordEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign id

        createUser = (Button) findViewById(R.id.createUserBut);
        moveToLogin = (Button) findViewById(R.id.moveToLogin);
        userEmailEdit = (EditText) findViewById(R.id.emailEditText);
        userpassWordEdit = (EditText) findViewById(R.id.passwordEditText);

        // on clock listeners




    }
}
