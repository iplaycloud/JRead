package com.iplay.jread.news.presenter;

import android.content.Context;

import com.iplay.jread.news.model.beans.NewsDetailBean;
import com.iplay.jread.news.model.NewsModel;
import com.iplay.jread.news.model.NewsModelImpl;
import com.iplay.jread.news.model.OnLoadNewsDetailListener;
import com.iplay.jread.news.view.NewsDetailView;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 2015/12/21
 */
public class NewsDetailPresenterImpl implements NewsDetailPresenter, OnLoadNewsDetailListener {

    private Context mContent;
    private NewsDetailView mNewsDetailView;
    private NewsModel mNewsModel;

    public NewsDetailPresenterImpl(Context mContent, NewsDetailView mNewsDetailView) {
        this.mContent = mContent;
        this.mNewsDetailView = mNewsDetailView;
        mNewsModel = new NewsModelImpl();
    }

    @Override
    public void loadNewsDetail(final String docId) {
        mNewsDetailView.showProgress();
        mNewsModel.loadNewsDetail(docId, this);
    }


    @Override
    public void onSuccess(NewsDetailBean newsDetailBean) {
        if (newsDetailBean != null) {
            mNewsDetailView.showNewsDetialContent(newsDetailBean.getBody());
        }
        mNewsDetailView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mNewsDetailView.hideProgress();
    }
}
