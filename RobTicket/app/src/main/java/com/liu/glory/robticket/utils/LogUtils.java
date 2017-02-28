package com.liu.glory.robticket.utils;

import android.util.Log;

/**
 * Created by liu.zhenrong on 2017/2/28.
 */

public class LogUtils {
    private static final String TAG = "robticket";
    private static boolean isPrintLog = true;

    public static void e(String msg){
        if(isPrintLog){
            Log.e(TAG,msg);
        }
    }
}
