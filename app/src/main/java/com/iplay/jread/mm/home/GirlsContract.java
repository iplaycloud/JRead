package com.iplay.jread.mm.home;

import com.iplay.jread.mm.base.BasePresenter;
import com.iplay.jread.mm.base.BaseView;
import com.iplay.jread.mm.data.bean.GirlsBean;

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
