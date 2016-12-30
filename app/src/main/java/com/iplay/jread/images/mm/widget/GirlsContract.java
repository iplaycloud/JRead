package com.iplay.jread.images.mm.widget;

import com.iplay.jread.images.mm.model.data.bean.GirlsBean;

import java.util.List;


/**
 * Created by oracleen on 2016/6/29.
 */
public interface GirlsContract {

    interface View {
        void refresh(List<GirlsBean.ResultsEntity> datas);

        void load(List<GirlsBean.ResultsEntity> datas);

        void showError();

        void showNormal();
    }

    interface Presenter{
        void getGirls(int page, int size, boolean isRefresh);
    }
}
