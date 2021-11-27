package com.example.myapp;

import android.content.Context;

public class Utils {
    //  将dp转成像素
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
