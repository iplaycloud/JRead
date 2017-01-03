package com.iplay.jread.video.model;

import android.util.Log;

import com.iplay.jread.commons.api.Urls;
import com.iplay.jread.images.jokeimg.model.ImageJsonUtils;
import com.iplay.jread.images.jokeimg.model.beans.ImageBean;
import com.iplay.jread.utils.OkHttpUtils;
import com.iplay.jread.video.model.beans.VideoBean;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/22
 */
public class VideoModelImpl implements IVideoModel {

    /**
     * 获取图片列表
     * @param listener
     */
    @Override
    public void loadVideoList(final OnLoadImageListListener listener) {

        String url = Urls.VIDEOS_URL;
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {

                Log.i("JSON", response);

                List<VideoBean> videoBeanList = VideoJsonUtils.readJson2VideoBeans(response);
                listener.onSuccess(videoBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load video list failure.", e);

                Log.i("JSON", "加载失败");
            }
        };

        //网络请求
        OkHttpUtils.get(url, loadNewsCallback);

    }

    public interface OnLoadImageListListener {
        void onSuccess(List<VideoBean> list);
        void onFailure(String msg, Exception e);
    }
}
