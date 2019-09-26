package com.joshuayingwhat.toucheventproject.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.joshuayingwhat.toucheventproject.PageViewAdapter;
import com.joshuayingwhat.toucheventproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joshuayingwhat
 */
public class ListFragment extends Fragment {

    private static final String KEY = "title_string";
    private TextView titleTv;
    private ViewPager childViewPager;
    private TextView numberPager;

    private List<Fragment> fragments;

    static ListFragment newInstance(String title) {
        ListFragment listFragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, title);
        listFragment.setArguments(bundle);
        return listFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_view_pager_fragment, container, false);
        childViewPager = (ViewPager) view.findViewById(R.id.child_view_pager);
        numberPager = (TextView) view.findViewById(R.id.number_page);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        String title = bundle != null ? bundle.getString(KEY, "") : null;

        fragments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ImageFragment imageFragment = ImageFragment.getInstance(R.drawable.huoying);
            fragments.add(imageFragment);
        }

        PageViewAdapter pageViewAdapter = new PageViewAdapter(getChildFragmentManager(), fragments);

        childViewPager.setAdapter(pageViewAdapter);
        childViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                numberPager.setText(String.format("%d/10", position + 1));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
