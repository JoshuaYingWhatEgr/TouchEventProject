package com.joshuayingwhat.toucheventproject.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.joshuayingwhat.toucheventproject.R;

public class ImageFragment extends Fragment {

    private static final String KEY = "image_fragment_id";
    private ImageView imageViewId;

    public static ImageFragment getInstance(int imageId) {
        ImageFragment imageFragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY, imageId);
        imageFragment.setArguments(bundle);
        return imageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_fragment_layout, container, false);
        imageViewId = view.findViewById(R.id.image_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        int imageId = bundle.getInt(KEY, -1);
        if (imageId != -1) {
            imageViewId.setImageResource(imageId);
        }
    }
}
