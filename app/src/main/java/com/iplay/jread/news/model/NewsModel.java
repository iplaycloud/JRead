package com.iplay.jread.news.model;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/19
 */
public interface NewsModel {

    void loadNews(String url, int type, OnLoadNewsListListener listener);

    void loadNewsDetail(String docid, OnLoadNewsDetailListener listener);

}
