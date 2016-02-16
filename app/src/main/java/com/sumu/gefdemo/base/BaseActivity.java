package com.sumu.gefdemo.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by gefufeng on 16/1/27.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    protected <T extends View> T findView(int id){
        return (T) findViewById(id);
    }
    protected <T extends View> T findView(int id,boolean isClick){
        T view = (T) findViewById(id);
        if (isClick){
            view.setOnClickListener(this);
        }
        return view;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View v) {

    }
}
