package com.iplay.jread.commons.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.iplay.jread.R;

/**
 * Created by renlei on 2016/5/23.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected Toolbar toolbar;

    //布局文件ID
    protected abstract int getContentViewId();

    //布局中Fragment的ID
    protected abstract int getFragmentContentId();

    protected <T extends View> T $(int id) {
        return (T) super.findViewById(id);
    }

    //添加fragment
    protected void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    //移除fragment
    protected void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    /**
     * 隐藏ToolBar
     */
    public void hideToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    /**
     * 显示ToolBar
     */
    public void showToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
        }
    }

    /**
     * 初始化ToolBar
     */
    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
//            toolbar.setLogo(R.mipmap.ic_top);
            toolbar.setBackgroundColor(getResources().getColor(R.color.theme_color));
            toolbar.setTitleTextAppearance(this, R.style.ToolBarTitleTextApperance);
            setSupportActionBar(toolbar);
        }
    }

    /**
     * 是否隐藏ToolBar返回按钮
     *
     * @param show
     */
    public void showOrHideToolBarNavigation(boolean show) {
        if (show) {
            toolbar.setNavigationIcon(R.mipmap.ic_top_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {
            toolbar.setNavigationIcon(null);
            toolbar.setNavigationOnClickListener(null);
        }
    }

    /**
     * 是否隐藏ToolBar Logo
     *
     * @param show
     */
    public void showOrHideToolBarLogo(boolean show) {
        if (show) {
//            toolbar.setLogo(R.mipmap.ic_top);
        } else {
            toolbar.setLogo(null);
        }
    }

    public abstract String returnToolBarTitle();

    private void setTitle() {
        if (toolbar != null) {
            String title = returnToolBarTitle();
            toolbar.setTitle(title);
        }
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
