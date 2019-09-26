package com.joshuayingwhat.toucheventproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.joshuayingwhat.toucheventproject.ui.FirstActivity;
import com.joshuayingwhat.toucheventproject.ui.ImageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * scrollerview和viewpager处理滑动冲突
 * 使用外部拦截法也就是在scrollerview中处理滑动事件
 *
 * @author joshuayingwhat
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button firstActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstActivity = (Button) findViewById(R.id.first_activity);
        firstActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_activity:
                startActivity(setActivity(FirstActivity.class));
                break;
            default:
                break;
        }
    }

    public Intent setActivity(Class<? extends Activity> cls) {
        return new Intent(this, cls);
    }
}
