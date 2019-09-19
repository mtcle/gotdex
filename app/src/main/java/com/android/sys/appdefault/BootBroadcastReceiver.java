package com.android.sys.appdefault;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.android.sys.appdefault.activity.SplashActivity;

/**
 * 作者：Lenovo on 2019/2/19 10:14
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {

            Intent mainActivityIntent = new Intent(context, SplashActivity.class);  // 要启动的Activity
            mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(mainActivityIntent);
        }
    }

}
