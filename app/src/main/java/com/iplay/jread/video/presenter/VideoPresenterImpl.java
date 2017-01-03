package com.iplay.jread.video.presenter;

import com.iplay.jread.video.model.IVideoModel;
import com.iplay.jread.video.model.VideoModelImpl;
import com.iplay.jread.video.model.beans.VideoBean;
import com.iplay.jread.video.view.IVideoView;

import java.util.List;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/22
 */
public class VideoPresenterImpl implements VideoPresenter, VideoModelImpl.OnLoadImageListListener {

    private IVideoModel mIVideoModel;
    private IVideoView mIVideoView;

    public VideoPresenterImpl(IVideoView iImageView) {
        this.mIVideoModel = new VideoModelImpl();
        this.mIVideoView = iImageView;
    }

    @Override
    public void loadVideoList() {
        mIVideoView.showProgress();
        mIVideoModel.loadVideoList(this);
    }

    @Override
    public void onSuccess(List<VideoBean> list) {
        mIVideoView.addVideos(list);
        mIVideoView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mIVideoView.hideProgress();
        mIVideoView.showLoadFailMsg();
    }
}
