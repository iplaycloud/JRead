package com.iplay.jread.news.view;

import com.iplay.jread.news.model.beans.NewsBean;

import java.util.List;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/18
 */
public interface NewsView {

    void showProgress();

    void addNews(List<NewsBean> newsList);

    void hideProgress();

    void showLoadFailMsg();
}
