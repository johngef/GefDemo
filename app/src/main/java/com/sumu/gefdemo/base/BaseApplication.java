package com.sumu.gefdemo.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by gefufeng on 15/12/8.
 */
public class BaseApplication extends Application{
    static Context _context;
    static Resources _resources;

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
        _resources = _context.getResources();
    }
    public static synchronized BaseApplication getInstance() {
        return (BaseApplication) _context;
    }

}
