package com.iplay.jread.main.splash;

import com.iplay.jread.img.app.MyApplication;
import com.iplay.jread.img.data.bean.GirlsBean;
import com.iplay.jread.img.data.source.GirlsDataSource;
import com.iplay.jread.img.data.source.GirlsResponsitory;

/**
 * Created by oracleen on 2016/6/28.
 */
public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;
    private GirlsResponsitory mResponsitory;

    public SplashPresenter(SplashContract.View view) {
        mView = view;
        mResponsitory = new GirlsResponsitory();
    }

    @Override
    public void start() {
        mResponsitory.getGirl(new GirlsDataSource.LoadGirlsCallback() {

            @Override
            public void onGirlsLoaded(GirlsBean girlsBean) {
                mView.showGirl(girlsBean.getResults().get(0).getUrl());
                MyApplication.currentGirl = girlsBean.getResults().get(0).getUrl();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showGirl();
            }

        });
    }
}
