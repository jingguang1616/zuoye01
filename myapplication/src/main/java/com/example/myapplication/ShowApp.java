package com.example.myapplication;

import android.app.Application;

import com.example.httplibrary.HttpConstant;
import com.example.httplibrary.HttpGlobalConfig;

import java.util.concurrent.TimeUnit;

public class ShowApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpGlobalConfig.getInsance()
                .setBaseUrl("https://www.wanandroid.com/")
                .setTimeout(HttpConstant.TIME_OUT)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .setShowLog(true)
                .initReady(this);
    }
}
