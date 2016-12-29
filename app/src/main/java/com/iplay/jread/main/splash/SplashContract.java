package com.iplay.jread.main.splash;

import com.iplay.jread.mm.base.BasePresenter;
import com.iplay.jread.mm.base.BaseView;

/**
 * Created by oracleen on 2016/6/28.
 */
public interface SplashContract {

    interface View extends BaseView<Presenter> {
        void showGirl(String girlUrl);

        void showGirl();
    }

    interface Presenter extends BasePresenter {

    }

}
