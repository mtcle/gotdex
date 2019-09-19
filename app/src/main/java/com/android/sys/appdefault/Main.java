package com.android.sys.appdefault;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 说明:hook 逻辑
 */
public class Main implements IXposedHookLoadPackage, IXposedHookZygoteInit {

    private static final String TAG = "mtcle";

    private Class Dex;
    private Method Dex_getBytes;
    private Method getDex;
    private String packagename;

    public static XSharedPreferences xSharedPreferences = new XSharedPreferences(BuildConfig.APPLICATION_ID, "XPOSED");

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {

        if (loadPackageParam.packageName.equals("android") || loadPackageParam.packageName.equals("de.robv.android.xposed.installer")) {
            return;
        }

        Log.e(TAG, "hook begin working ...");
        if ( loadPackageParam.packageName.equals(BuildConfig.APPLICATION_ID)) {
            XposedHelpers.findAndHookMethod("com.android.sys.appdefault.MainApplication", loadPackageParam.classLoader, "isXposedWork", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                    Log.e(TAG, "hook 自检通过");
                    return true;
                }
            });
            // return;
        }
        xSharedPreferences.makeWorldReadable();
        xSharedPreferences.reload();
        initRefect();
        packagename = xSharedPreferences.getString("packagename", null);
        Log.e(TAG, "需要hook的包名：" + packagename);
        if ((!loadPackageParam.packageName.equals(packagename))||packagename == null) {
            XposedBridge.log("hook 包名为空,或者不一致，不处理");
            return;
        }
        Log.e(TAG, "目标包名：" + loadPackageParam.packageName);
        String str = "java.lang.ClassLoader";
        String str2 = "loadClass";

        XposedHelpers.findAndHookMethod(str, loadPackageParam.classLoader, str2, String.class, Boolean.TYPE, new XC_MethodHook() {
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Log.e(TAG, "开始工作");
                Class cls = (Class) param.getResult();
                if (cls == null) {
                    XposedBridge.log("cls == null");
                    return;
                }
                String name = cls.getName();
//                Log.e(TAG, "当前类名：" + name);
                byte[] bArr = (byte[]) Dex_getBytes.invoke(getDex.invoke(cls, new Object[0]), new Object[0]);
                if (bArr == null) {
//                    Log.e(TAG, "数据为空：返回");
                    return;
                }

                String dex_path = "/data/data/" + packagename + "/" + packagename+"_" + bArr.length + ".dex";
                Log.e(TAG, "开始写数据：" + dex_path);
                File file = new File(dex_path);
                if (file.exists()) {
                    return;
                }
                writeByte(bArr, file.getAbsolutePath());
            }
        });

    }

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        xSharedPreferences.makeWorldReadable();
    }

    public void initRefect() {
        try {
            Dex = Class.forName("com.android.dex.Dex");
            Dex_getBytes = Dex.getDeclaredMethod("getBytes", new Class[0]);
            getDex = Class.forName("java.lang.Class").getDeclaredMethod("getDex", new Class[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public void writeByte(byte[] bArr, String str) {
        try {
            OutputStream outputStream = new FileOutputStream(str);
            outputStream.write(bArr);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "文件写出失败");
        }
    }
}
