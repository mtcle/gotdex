package com.android.sys.appdefault.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.sys.appdefault.MainApplication;

public class SplashActivity extends AppCompatActivity {

    private final Handler uiHandler = new Handler();
    private final Integer splashTimeOut = 1 * 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        uiHandler.postDelayed(() -> {
            if (/*!BuildConfig.DEBUG &&*/ !MainApplication.getInstance().isXposedWork()) {
                Toast.makeText(this, "没有xposed框架，请检查！！！", Toast.LENGTH_LONG).show();
                SplashActivity.this.finish();
                return;
            }


            Intent intent = new Intent(SplashActivity.this, DetailActivity.class);
            SplashActivity.this.startActivityForResult(intent, 0);
            finish();
        }, splashTimeOut);
    }
}
