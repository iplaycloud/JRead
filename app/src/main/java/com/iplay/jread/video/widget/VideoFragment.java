package com.iplay.jread.video.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iplay.jread.R;
import com.iplay.jread.images.jokeimg.widget.ImagesListFragment;
import com.iplay.jread.images.mm.widget.GirlsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/13
 */
public class VideoFragment extends Fragment {

    public static final int NEWS_TYPE_MM = 0;
    public static final int NEWS_TYPE_JOKES = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.video_fragment_video, null);

        ButterKnife.bind(this, view);

        return view;
    }

}

