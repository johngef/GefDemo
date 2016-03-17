package com.sumu.gefdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by gefufeng on 16/3/15.
 */
public class MyLinearLayout extends LinearLayout{
    public MyLinearLayout(Context context) {
        this(context,null);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.e("touch","MyLinearLayout-----dispatchTouchEvent---begin");
//        boolean b = super.dispatchTouchEvent(ev);
//        Log.e("touch","MyLinearLayout-----dispatchTouchEvent---" + b );
//        return b;
//    }
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.e("touch","MyLinearLayout-----onInterceptTouchEvent---begin");
//        boolean b = super.onInterceptTouchEvent(ev);
//        Log.e("touch","MyLinearLayout-----onInterceptTouchEvent---" + b );
//        return b;
//    }

}
