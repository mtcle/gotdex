package com.android.sys.appdefault.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.sys.appdefault.BuildConfig;
import com.android.sys.appdefault.MainApplication;

import java.io.File;

/**
 * 作者：Lenovo on 2019/9/19 16:22
 * 描述：
 */
public class XSPUtils {
    private static final XSPUtils instance = new XSPUtils();

    private XSPUtils() {
    }

    public static XSPUtils getInstance() {
        return instance;
    }

    public SharedPreferences getSharedPreferences() {
        return MainApplication.getInstance().getSharedPreferences("XPOSED", Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);
    }

    public String get(String key) {
        return getSharedPreferences().getString(key, null);
    }

    public void set(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
        resetFilePermission();
    }

    public void remove(String packageName) {
        getSharedPreferences().edit().remove(packageName).apply();
        resetFilePermission();
    }

    private void resetFilePermission() {
        File sharedPreferencesFile = new File("/data/data/" + BuildConfig.APPLICATION_ID + "/shared_prefs/", "XPOSED.xml");

        sharedPreferencesFile.setReadable(true, false);
        sharedPreferencesFile.setWritable(true, false);
    }
}
