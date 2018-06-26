package com.limbo.demo_test;

import android.app.Application;

import com.limbo.sdk_demo.YunNa;

/**
 * Created by wangqi on 2018/6/14.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        YunNa.init(this);
    }
}
