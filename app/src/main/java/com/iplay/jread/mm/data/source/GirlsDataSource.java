package com.iplay.jread.mm.data.source;

import com.iplay.jread.mm.data.bean.GirlsBean;

/**
 * Created by oracleen on 2016/6/29.
 */
public interface GirlsDataSource {

    interface LoadGirlsCallback {

        void onGirlsLoaded(GirlsBean girlsBean);

        void onDataNotAvailable();
    }

    void getGirls(int page, int size, LoadGirlsCallback callback);

    void getGirl(LoadGirlsCallback callback);
}