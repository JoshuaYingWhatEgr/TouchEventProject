package com.joshuayingwhat.toucheventproject.ui;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.joshuayingwhat.toucheventproject.PageViewAdapter;
import com.joshuayingwhat.toucheventproject.R;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private TextView numberTv;

    private ViewPager viewPager;

    private List<Fragment> imageFragment;

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_in_scroller_view);
        numberTv = (TextView) findViewById(R.id.number_tv_view);
        viewPager = (ViewPager) findViewById(R.id.vp_view);

        frameLayout = (FrameLayout) findViewById(R.id.fragment_layout);

        imageFragment = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ImageFragment imageFragment = ImageFragment.getInstance(R.drawable.huoying);
            this.imageFragment.add(imageFragment);
        }
        PagerAdapter pagerAdapter = new PageViewAdapter(getSupportFragmentManager(), imageFragment);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                numberTv.setText(String.format("%d/10", position + 1));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
