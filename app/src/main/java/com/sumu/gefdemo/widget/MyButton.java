package com.sumu.gefdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by gefufeng on 16/3/15.
 */
public class MyButton extends Button {
    public MyButton(Context context) {
        this(context,null);
    }

    public MyButton(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("touch", "MyButton-----dispatchTouchEvent---begin");
        boolean b = super.dispatchTouchEvent(event);
        Log.e("touch", "MyButton-----dispatchTouchEvent---" + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("touch", "MyButton-----onTouchEvent---begin");
        boolean b = super.onTouchEvent(event);
        Log.e("touch", "MyButton-----onTouchEvent---" + b);
        return  false;
    }

}
