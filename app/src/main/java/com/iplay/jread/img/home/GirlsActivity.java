package com.iplay.jread.img.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.iplay.jread.R;
import com.iplay.jread.img.about.AboutActivity;
import com.iplay.jread.commons.base.AppActivity;
import com.iplay.jread.commons.base.BaseFragment;

public class GirlsActivity extends AppActivity {

    @BindView(R.id.fab)
    FloatingActionButton mFab;

    private long exitTime = 0;

    @Override
    protected int getContentViewId() {
        return R.layout.img_activity_home;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.girls_fragment;
    }

    @Override
    public String returnToolBarTitle() {
        return "MeiZi";
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

    @OnClick(R.id.fab)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                // 必须明确使用mailto前缀来修饰邮件地址,如果使用
                Uri uri = Uri.parse("mailto:18231195685@sina.cn");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(Intent.createChooser(intent, "请选择邮件类应用"));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            Intent intent = new Intent(GirlsActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected BaseFragment getFirstFragment() {
        return GirlsFragment.getInstance();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Snackbar.make(mFab, "再按一次退出程序哦~", Snackbar.LENGTH_LONG).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
