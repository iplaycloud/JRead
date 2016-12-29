package com.iplay.jread.img.home;

import com.iplay.jread.img.BasePresenter;
import com.iplay.jread.img.BaseView;
import com.iplay.jread.img.data.bean.GirlsBean;

import java.util.List;


/**
 * Created by oracleen on 2016/6/29.
 */
public interface GirlsContract {

    interface View extends BaseView {
        void refresh(List<GirlsBean.ResultsEntity> datas);

        void load(List<GirlsBean.ResultsEntity> datas);

        void showError();

        void showNormal();
    }

    interface Presenter extends BasePresenter {
        void getGirls(int page, int size, boolean isRefresh);
    }
}
