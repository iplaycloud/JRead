package com.iplay.jread.images.jokeimg.presenter;

import com.iplay.jread.images.jokeimg.model.beans.ImageBean;
import com.iplay.jread.images.jokeimg.model.IImageModel;
import com.iplay.jread.images.jokeimg.model.ImageModelImpl;
import com.iplay.jread.images.jokeimg.view.IImageView;

import java.util.List;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/22
 */
public class ImagePresenterImpl implements ImagePresenter, ImageModelImpl.OnLoadImageListListener {

    private IImageModel mIImageModel;
    private IImageView mIImageView;

    public ImagePresenterImpl(IImageView iImageView) {
        this.mIImageModel = new ImageModelImpl();
        this.mIImageView = iImageView;
    }

    @Override
    public void loadImageList() {
        mIImageView.showProgress();
        mIImageModel.loadImageList(this);
    }

    @Override
    public void onSuccess(List<ImageBean> list) {
        mIImageView.addImages(list);
        mIImageView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mIImageView.hideProgress();
        mIImageView.showLoadFailMsg();
    }
}
