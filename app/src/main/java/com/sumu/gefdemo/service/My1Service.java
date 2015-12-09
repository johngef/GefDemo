package com.sumu.gefdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class My1Service extends Service {
    public My1Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e("sumu","-----My1Service-----onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.e("sumu","-----My1Service-----onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("sumu","-----My1Service-----onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("sumu","-----My1Service-----onUnbind");

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("sumu","-----My1Service-----onDestroy");

        super.onDestroy();
    }
}
