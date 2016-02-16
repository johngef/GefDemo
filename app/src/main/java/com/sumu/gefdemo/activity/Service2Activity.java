package com.sumu.gefdemo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sumu.gefdemo.R;
import com.sumu.gefdemo.service.My2Service;

public class Service2Activity extends AppCompatActivity {
    private Intent bindintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service2);
    }
    public void bindService(View view) {
        bindintent = new Intent(this, My2Service.class);
        bindService(bindintent,serviceConnection,BIND_AUTO_CREATE);

    }
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("sumu", "------onServiceConnected-----" + name + "-----" + service);
            My2Service.MyBinder myBinder = (My2Service.MyBinder) service;
            myBinder.run();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("sumu","------onServiceDisconnected-----" + name);
        }
    };
}
