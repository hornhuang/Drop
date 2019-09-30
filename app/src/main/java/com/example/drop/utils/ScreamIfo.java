package com.example.drop.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

import com.example.drop.App;

public final class ScreamIfo {

    private static int SCREAMWIDTH;

    private static int SCREAMHEIGHT;

    public static void create(@NonNull Context appContext) {
        DisplayMetrics metrics = appContext.getResources().getDisplayMetrics();
        SCREAMWIDTH  = metrics.widthPixels;
        SCREAMHEIGHT = metrics.heightPixels;
    }

    public static int getSCREAMHEIGHT() {
        if (SCREAMHEIGHT == 0)
            create(App.getAppContext());
        return SCREAMHEIGHT;
    }

    public static int getSCREAMWIDTH() {
        if (SCREAMWIDTH == 0)
            create(App.getAppContext());
        return SCREAMWIDTH;
    }

}
