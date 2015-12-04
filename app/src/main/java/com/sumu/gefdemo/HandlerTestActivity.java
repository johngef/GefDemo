package com.sumu.gefdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class HandlerTestActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);
        View view = new View(this);
        view.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }



    Handler handler = new Handler(){

    };


}
