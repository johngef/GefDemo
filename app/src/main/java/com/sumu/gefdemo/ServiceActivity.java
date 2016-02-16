package com.sumu.gefdemo;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.sumu.gefdemo.activity.Service2Activity;
import com.sumu.gefdemo.service.My1Service;
import com.sumu.gefdemo.service.My2Service;

public class ServiceActivity extends ActionBarActivity {
    public static final int FLAG_BING_SERVICE = 11;
    private Intent startintent;
    private Intent bindintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }
    public void startservice(View view){
        /*
            -----My1Service-----onCreate
            -----My1Service-----onStartCommand
            再次点击执行-----My1Service-----onStartCommand
         */
        startintent = new Intent(this, My1Service.class);
        startService(startintent);

    }
    public void bindservice(View view){
        /**
         *-----My2Service-----onCreate
         -----My2Service-----onBind
         ------onServiceConnected-----ComponentInfo{com.sumu.gefdemo/com.sumu.gefdemo.service.My2Service}-----com.sumu.gefdemo.service.My2Service$MyBinder@41d6bfe0
         -----My2Service-----run
         再次点击什么都不执行
         */

        bindintent = new Intent(this, My2Service.class);
        bindService(bindintent,serviceConnection,BIND_AUTO_CREATE);
    }
    public void stopservice(View view){
        /**
         * -----My1Service-----onDestroy
         */
        stopService(startintent);
//        stopService(bindintent);//不起作用
    }
    public void unbindservice(View view){
        /**
         * -----My2Service-----onUnbind
         12-----My2Service-----onDestroy
         */

        unbindService(serviceConnection);
    }
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("sumu","------onServiceConnected-----" + name + "-----" + service);
            My2Service.MyBinder myBinder = (My2Service.MyBinder) service;
            myBinder.run();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("sumu","------onServiceDisconnected-----" + name);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unbindService(serviceConnection);
    }
    public void startService2Activity(View view){
        startActivity(new Intent(this, Service2Activity.class));

    }
}
