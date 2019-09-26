package com.joshuayingwhat.toucheventproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.joshuayingwhat.toucheventproject.ui.FirstActivity;
import com.joshuayingwhat.toucheventproject.ui.SecondActivity;


/**
 * scrollerview和viewpager处理滑动冲突
 * 使用外部拦截法也就是在scrollerview中处理滑动事件
 *
 * @author joshuayingwhat
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button firstActivity;
    private Button secondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstActivity = (Button) findViewById(R.id.first_activity);
        firstActivity.setOnClickListener(this);
        secondActivity = (Button) findViewById(R.id.second_activity);
        secondActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_activity:
                startActivity(setActivity(FirstActivity.class));
                break;
            case R.id.second_activity:
                startActivity(setActivity(SecondActivity.class));
                break;
            default:
                break;
        }
    }

    public Intent setActivity(Class<? extends Activity> cls) {
        return new Intent(this, cls);
    }
}
