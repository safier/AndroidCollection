package com.safier.androidcollection;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * @author safier
 * @date 2019/3/8
 */
public class ApplicationCollection extends Application {

    private static Application instance;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Application getInstance() {
        return instance;
    }
}
