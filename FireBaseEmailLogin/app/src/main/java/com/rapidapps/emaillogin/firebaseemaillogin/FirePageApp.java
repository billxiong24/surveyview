package com.example.shreyasingh.firebaseemaillogin;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by shreyasingh on 10/25/17.
 */

public class FirePageApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        if(FirebaseApp.getApps(this) .isEmpty())
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }
}
