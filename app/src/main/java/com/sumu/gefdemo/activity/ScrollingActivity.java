package com.sumu.gefdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Contacts;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.sumu.gefdemo.R;

import java.io.File;

public class ScrollingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        File file = getFilesDir();
        Log.d("getFilesDir",getFilesDir().getAbsolutePath());
        Log.d("getCacheDir",getCacheDir().getAbsolutePath());
        Log.d("getDataDirectory", Environment.getDataDirectory().getAbsolutePath());
        Log.d("getExternalStorageDirectory", Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d("getDownloadCacheDirectory", Environment.getDownloadCacheDirectory().getAbsolutePath());
        Log.d("getExternalStoragePublicDirectory", Environment.getExternalStoragePublicDirectory("").getAbsolutePath());
        Log.d("getRootDirectory", Environment.getRootDirectory().getAbsolutePath());
        Log.d("getExternalCacheDir", getExternalCacheDir().getAbsolutePath());
        Log.d("getExternalFilesDir", getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        /**
         * 05-15 23:06:10.221 19898-19898/com.sumu.gefdemo D/getFilesDir: /data/data/com.sumu.gefdemo/files
         05-15 23:06:10.221 19898-19898/com.sumu.gefdemo D/getCacheDir: /data/data/com.sumu.gefdemo/cache
         05-15 23:06:10.221 19898-19898/com.sumu.gefdemo D/getDataDirectory: /data
         05-15 23:06:10.221 19898-19898/com.sumu.gefdemo D/getExternalStorageDirectory: /storage/emulated/0
         05-15 23:06:10.221 19898-19898/com.sumu.gefdemo D/getDownloadCacheDirectory: /cache
         05-15 23:06:10.221 19898-19898/com.sumu.gefdemo D/getExternalStoragePublicDirectory: /storage/emulated/0
         05-15 23:06:10.221 19898-19898/com.sumu.gefdemo D/getRootDirectory: /system
         05-15 23:06:10.229 19898-19898/com.sumu.gefdemo D/getExternalCacheDir: /storage/emulated/0/Android/data/com.sumu.gefdemo/cache
         05-15 23:06:10.231 19898-19898/com.sumu.gefdemo D/getExternalFilesDir: /storage/emulated/0/Android/data/com.sumu.gefdemo/files/Download
         */
//        Contacts.People.
//        managedQuery()
    }

}
