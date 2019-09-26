package com.joshuayingwhat.toucheventproject.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

import androidx.annotation.RequiresApi;

/**
 * @author joshuayingwhat
 */
public class VerticalScrollView extends ScrollView {

    public VerticalScrollView(Context context) {
        super(context);
    }

    public VerticalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public VerticalScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    float dotX = 0;

    float dotY = 0;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float x = ev.getX();

        float y = ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                dotX = x;
                dotY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float distanceX = Math.abs(x - dotX);
                float distanceY = Math.abs(y - dotY);

                if (distanceX > distanceY) {
                    //将事件分发给viewpager
                    return false;
                }
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }
}
