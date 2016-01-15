package com.sumu.gefdemo.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.sumu.gefdemo.R;

public class AnimationActivity extends AppCompatActivity {
    private TextView rotate;
    private TextView frameAnimation;
    private TextView object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        rotate = (TextView) findViewById(R.id.rotate);
        frameAnimation = (TextView) findViewById(R.id.fram_animation);
        object = (TextView) findViewById(R.id.object_animation);
        object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击我了",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void startObjectAnimation(View view){
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.object);
        animator.setTarget(object);
        animator.start();
    }
    public void startFrameAnimation(View view){
        AnimationDrawable animationDrawable = (AnimationDrawable) getDrawable(R.drawable.frame_animation);
        frameAnimation.setBackground(animationDrawable);
        animationDrawable.start();

    }

    public static class ViewWrapper{
        private TextView target;

        public ViewWrapper(TextView target) {
            this.target = target;
        }
        public int getWidth(){
           return target.getLayoutParams().width;
        }
        public void setWidth(int width){
            target.getLayoutParams().width = width;
            target.requestLayout();
        }

    }

    public void startAnimation(View view){
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
                Toast.makeText(getApplicationContext(),"完成",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rotate.startAnimation(animation);
    }
}
