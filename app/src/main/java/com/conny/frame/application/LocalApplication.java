package com.conny.frame.application;

import android.app.Application;

/**
 * Desc:
 * Created by zhanghui on 2017/11/13.
 */

public class LocalApplication extends Application {

    public static Application APP;

    @Override
    public void onCreate() {
        super.onCreate();
        APP = this;
    }
}