package com.example.six_0112_week3;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class CrashHandler implements Thread.UncaughtExceptionHandler{
    public static final String TAG="CrashHandler";
    private static CrashHandler mInstance;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Context mContext;
    public static synchronized CrashHandler getInstance() {
        if (null == mInstance) {
            mInstance = new CrashHandler();
        }
        return mInstance;
    }
    public void init(Context context) {
        mContext = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (!handleException(e) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(t, e);
        } else {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException es) {
                Log.e(TAG, "error : ", es);
            }
        }
    }
    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }
        addCustomInfo();
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(mContext, "程序开小差了呢..", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();
        return true;
    }
    private void addCustomInfo() {
        Log.i(TAG, "addCustomInfo: 程序出错了...");
    }



}
