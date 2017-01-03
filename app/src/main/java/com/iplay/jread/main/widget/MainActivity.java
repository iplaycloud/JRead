package com.iplay.jread.main.widget;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.iplay.jread.R;
import com.iplay.jread.about.widget.AboutFragment;
import com.iplay.jread.commons.base.BaseActivity;
import com.iplay.jread.images.ImagesFragment;
import com.iplay.jread.main.presenter.MainPresenter;
import com.iplay.jread.main.presenter.MainPresenterImpl;
import com.iplay.jread.main.view.MainView;
import com.iplay.jread.news.widget.NewsFragment;
import com.iplay.jread.video.widget.TestVideoFragment;
import com.iplay.jread.video.widget.VideoListFragment;
import com.iplay.jread.weather.widget.WeatherFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/13
 */
public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.tv_main_news)
    TextView tv_main_news;

    @BindView(R.id.tv_main_images)
    TextView tv_main_images;

    @BindView(R.id.tv_main_video)
    TextView tv_main_video;

    @BindView(R.id.tv_main_setting)
    TextView tv_main_setting;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(mNavigationView);

        mMainPresenter = new MainPresenterImpl(this);

        switch2News();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mMainPresenter.switchNavigation(menuItem.getItemId());
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.tv_main_news:
                switch2News();
                break;

            case R.id.tv_main_images:
                switch2Images();

                break;

            case R.id.tv_main_video:
                switch2Video();

                break;

            case R.id.tv_main_setting:
                switch2News();
                setMainMenuTextDefault();
                tv_main_setting.setTextColor(Color.BLACK);
                break;
        }
    }

    public void setMainMenuTextDefault()
    {
        tv_main_news.setTextColor(Color.GRAY);
        tv_main_images.setTextColor(Color.GRAY);
        tv_main_video.setTextColor(Color.GRAY);
        tv_main_setting.setTextColor(Color.GRAY);
    }

    @Override
    public void switch2News() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
        mToolbar.setTitle(R.string.navigation_news);

        setMainMenuTextDefault();
        tv_main_news.setTextColor(Color.BLACK);
    }

    @Override
    public void switch2Images() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new ImagesFragment()).commit();
        mToolbar.setTitle(R.string.navigation_images);

        setMainMenuTextDefault();
        tv_main_images.setTextColor(Color.BLACK);

        //ActivityManager.getInstance().finishActivity();
    }

    @Override
    public void switch2Mm() {
    }

    @Override
    public void switch2Video() {

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new VideoListFragment()).commit();
        mToolbar.setTitle(R.string.navigation_video);

        setMainMenuTextDefault();
        tv_main_video.setTextColor(Color.BLACK);
    }

    @Override
    public void switch2Weather() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new WeatherFragment()).commit();
        mToolbar.setTitle(R.string.navigation_weather);
    }

    @Override
    public void switch2About() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new AboutFragment()).commit();
        mToolbar.setTitle(R.string.navigation_about);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    public String returnToolBarTitle() {
        return " ";
    }
}
