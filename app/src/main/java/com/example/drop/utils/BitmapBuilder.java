package com.example.drop.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;

public class BitmapBuilder {

    public static BitmapFactory.Options calculateOptionsById(int imgId, @NonNull Context activityContext) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(activityContext.getResources(), imgId, options);
        options.inJustDecodeBounds = false;
        return options;
    }

    public static int calculateInSamplesizeByOptions(@NonNull BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int inSamplesize   = 1;
        int originalWidth  = options.outWidth;
        int originalHeight = options.outHeight;
        if (originalHeight > reqHeight || originalWidth > reqWidth) {
            int heightRatio = originalHeight / reqHeight;
            int widthRatio  = originalWidth  / reqWidth;
            inSamplesize = heightRatio > widthRatio ? heightRatio : widthRatio;
        }
        return inSamplesize;
    }

    public static Bitmap decodeBitmapById (@NonNull Context activityContext, int resId,  int reqWidth, int reqHeight) {
        BitmapFactory.Options options = calculateOptionsById(resId, activityContext);
        options.inSampleSize = calculateInSamplesizeByOptions(options, reqWidth, reqHeight);
        Bitmap bitmap = BitmapFactory.decodeResource(activityContext.getResources(), resId, options);
        return bitmap;
    }

}
