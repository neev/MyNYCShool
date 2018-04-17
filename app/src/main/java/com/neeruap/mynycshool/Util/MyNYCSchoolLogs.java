package com.neeruap.mynycshool.Util;

import android.util.Log;

public class MyNYCSchoolLogs {

    private static String TAG = "MyNYCSchool_LOGS";

    public static void d(String message) {
        Log.d(TAG, "Debug: " + message);
    }

}
