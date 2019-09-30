package com.example.drop.utils;

import android.content.Context;

public final class MemoryIfo {

    private static long maxMemory;

    public static long getInstance() {
        if (maxMemory == 0) {
            maxMemory = Runtime.getRuntime().maxMemory() / 1024;
        }
        return maxMemory;
    }
}
