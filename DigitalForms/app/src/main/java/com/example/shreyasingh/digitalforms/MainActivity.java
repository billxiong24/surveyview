package com.example.shreyasingh.digitalforms;

import android.view.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCreateFormActivity (View view) {
        Intent intent = new Intent (this, openCreateFormActivity.class);

    }

}
