package com.sumu.gefdemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.sumu.gefdemo.R;

import java.util.Random;

/**
 * Created by gefufeng on 16/1/8.
 */
public class MyView extends View{
    private int customColor;
    private String customText;
    private int customTextSize;
    private Paint paint;
    private Rect rect;

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }
    public MyView(Context context) {
        this(context, null, 0);

    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyView, defStyleAttr,0);
        int count = typedArray.getIndexCount();
        for(int i = 0;i < count;i++){
            int attr = typedArray.getIndex(i);
            switch (attr){
                case R.styleable.MyView_custom_text:
                    customText = typedArray.getString(attr);
                    break;
                case R.styleable.MyView_custom_textcolor:
                    customColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.MyView_custom_textsize:
                    customTextSize = typedArray.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }

        }

        typedArray.recycle();
        paint = new Paint();
        paint.setTextSize(customTextSize);
        rect = new Rect();
        paint.getTextBounds(customText,0,customText.length(),rect);


        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                customText = random.nextInt(100) + "";
                invalidate();
            }
        });

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width;
        int height;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY){
            width = widthSize;
        }else{
            width = getPaddingLeft() + rect.width() + getPaddingLeft();
        }
        if (heightMode == MeasureSpec.EXACTLY){
            height = heightSize;
        }else{
            height = getPaddingBottom() + rect.height() + getPaddingTop();
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        paint.setColor(customColor);
        canvas.drawText(customText, getMeasuredWidth() / 2 - rect.width() / 2, getMeasuredHeight() / 2 + rect.height() / 2, paint);
    }
}
