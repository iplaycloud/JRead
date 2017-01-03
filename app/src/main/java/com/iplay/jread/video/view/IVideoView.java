package com.iplay.jread.video.view;

import com.iplay.jread.video.model.beans.VideoBean;

import java.util.List;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/22
 */
public interface IVideoView {
    void addVideos(List<VideoBean> list);
    void showProgress();
    void hideProgress();
    void showLoadFailMsg();
}
