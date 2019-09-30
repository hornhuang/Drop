package com.example.drop;

import android.app.Application;
import android.content.Context;

import com.example.drop.utils.ScreamIfo;

public class App extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;
        ScreamIfo.create(this);

    }

    public static Context getAppContext() {
        return appContext;
    }
}
