package com.joshuayingwhat.toucheventproject.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.joshuayingwhat.toucheventproject.PageViewAdapter;
import com.joshuayingwhat.toucheventproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joshuayingwhat
 */
public class SecondActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private List<Fragment> fragments;

    private final String[] mTitles = new String[]{
            "聊天", "主播", "排行榜", "贵宾"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_viewpager_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        fragments = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            ListFragment listFragment = ListFragment.newInstance(mTitles[i]);
            fragments.add(listFragment);
        }

        PageViewAdapter pageViewAdapter = new PageViewAdapter(getSupportFragmentManager(), fragments, mTitles);
        viewPager.setAdapter(pageViewAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
