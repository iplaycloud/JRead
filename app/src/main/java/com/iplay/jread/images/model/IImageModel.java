package com.iplay.jread.images.model;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/22
 */
public interface IImageModel {
    void loadImageList(ImageModelImpl.OnLoadImageListListener listener);
}
