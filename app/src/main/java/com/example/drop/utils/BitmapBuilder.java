package com.example.drop.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;

public class BitmapBuilder {

    public static void calculateOptionsById(@NonNull Resources res,@NonNull BitmapFactory.Options options, int imgId) {
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, imgId, options);
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
        options.inJustDecodeBounds = false;
        return inSamplesize;
    }

    public static Bitmap decodeBitmapById (@NonNull Resources res, int resId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        calculateOptionsById(res, options, resId);
        options.inSampleSize = calculateInSamplesizeByOptions(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(res, resId, options);
        return bitmap;
    }

}
