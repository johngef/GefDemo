package com.sumu.gefdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

public class HandlerTestActivity extends ActionBarActivity {
    private TextView text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);
        text = (TextView) findViewById(R.id.textView2);
        text.setText(Thread.currentThread().getName());

    }
    /**
     * 三种刷新textView的方式
     */
    public void sunThread(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                final String threadName = Thread.currentThread().getName();
                //1
//                text.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        text.setText(threadName);
//                    }
//                });
                //2
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        text.setText(threadName);
//                    }
//                });
                //3
                Message message = Message.obtain();
                message.what = 1;
                message.obj = threadName;
                handler.sendMessage(message);
            }
        }).start();
    }



    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                text.setText((String) msg.obj);
            }
        }
    };


}
