package com.iplay.jread.video.model;

import java.net.MalformedURLException;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/22
 */
public interface IVideoModel {
    void loadVideoList(VideoModelImpl.OnLoadImageListListener listener);
}
