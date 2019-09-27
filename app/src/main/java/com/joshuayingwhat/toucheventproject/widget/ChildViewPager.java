package com.joshuayingwhat.toucheventproject.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class ChildViewPager extends ViewPager {
    public ChildViewPager(@NonNull Context context) {
        super(context);
    }

    public ChildViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 内部拦截法
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //将点击事件给子view
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int count = this.getAdapter().getCount();
                int currentItem = this.getCurrentItem();

                if (currentItem == 0 || currentItem == count - 1) {
                    //如果当前页面是最后一页和第0页就由父布局拦截点击事件
                    //当前事件不传递给子view
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(ev);
    }
}
