package com.joshuayingwhat.toucheventproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class PageViewAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    private FragmentManager fm;

    public PageViewAdapter(@NonNull FragmentManager fm) {
        super(fm);

        this.fm = fm;
    }

    public PageViewAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }
}
