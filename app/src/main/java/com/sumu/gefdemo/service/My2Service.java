package com.sumu.gefdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class My2Service extends Service {
    public My2Service() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e("sumu","-----My2Service-----onBind");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        Log.e("sumu","-----My2Service-----onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("sumu","-----My2Service-----onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("sumu","-----My2Service-----onUnbind");

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("sumu","-----My2Service-----onDestroy");

        super.onDestroy();
    }
    public class MyBinder extends Binder{
        public void run(){
            Log.e("sumu","-----My2Service-----run");
        }
    }

}
