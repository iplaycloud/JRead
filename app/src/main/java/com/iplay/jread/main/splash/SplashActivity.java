package com.iplay.jread.main.splash;

import android.view.View;

import com.iplay.jread.R;
import com.iplay.jread.commons.base.AppActivity;
import com.iplay.jread.commons.base.BaseFragment;


public class SplashActivity extends AppActivity {

    @Override
    protected BaseFragment getFirstFragment() {
        return SplashFragment.getInstance();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.img_activity_splash;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.splash_fragment;
    }

    @Override
    public String returnToolBarTitle() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }
}
