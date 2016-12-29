package com.iplay.jread.img.girl;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.iplay.jread.R;
import com.iplay.jread.commons.base.AppActivity;
import com.iplay.jread.commons.base.BaseFragment;
import com.iplay.jread.utils.ColorUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oracleen on 2016/7/4.
 */
public class GirlActivity extends AppActivity implements GirlFragment.OnGirlChange {

    GirlFragment mGirlFragment;

    @Override
    protected int getContentViewId() {
        return R.layout.img_activity_girl;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.girl_fragment;
    }

    @Override
    public String returnToolBarTitle() {
        return "MeiZiTu";
    }

    @Override
    protected BaseFragment getFirstFragment() {
        mGirlFragment = GirlFragment.newInstance(getIntent().getParcelableArrayListExtra("girls"), getIntent().getIntExtra("current", 0));
        return mGirlFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        initToolBar();
        showOrHideToolBarNavigation(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_girl, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_share) {
            mGirlFragment.shareGirl();
            return true;
        } else if (id == R.id.action_save) {
            mGirlFragment.saveGirl();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void change(int color) {
//        mToolbar.setBackgroundColor(color);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.setStatusBarColor(ColorUtil.colorBurn(color));
            window.setNavigationBarColor(ColorUtil.colorBurn(color));
        }
    }
}
