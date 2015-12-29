package com.sumu.gefdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.sumu.gefdemo.R;

public class AnimationActivity extends AppCompatActivity {
    private TextView rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        rotate = (TextView) findViewById(R.id.rotate);
        viewRotate();
    }
    private void viewRotate(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.tween_animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rotate.startAnimation(animation);
    }
}
