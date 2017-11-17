package com.conny.frame.application;

import android.app.Application;

import com.conny.frame.material.utils.ResourcesUtil;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orm.SugarContext;

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
        ResourcesUtil.init(getResources());

        //初始化Logger
        Logger.addLogAdapter(new AndroidLogAdapter());

        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        SugarContext.terminate();
        super.onTerminate();
    }
}
