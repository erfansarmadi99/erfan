package com.example.aparat.confings;

import android.app.Application;

import androidx.multidex.MultiDex;

public class AppConfinguration extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(getApplicationContext());
    }
}
