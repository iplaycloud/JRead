package com.iplay.jread.images.jokeimg.view;

import com.iplay.jread.images.jokeimg.model.beans.ImageBean;

import java.util.List;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/22
 */
public interface IImageView {
    void addImages(List<ImageBean> list);
    void showProgress();
    void hideProgress();
    void showLoadFailMsg();
}
