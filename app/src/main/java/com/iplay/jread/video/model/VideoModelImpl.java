package com.iplay.jread.video.model;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.iplay.jread.commons.api.Urls;
import com.iplay.jread.video.model.beans.VideoBean;
import com.iplay.jread.video.utils.VideoJsonUtils;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/22
 */
public class VideoModelImpl implements IVideoModel {

    private OkHttpClient mOkHttpClient;

    private Handler mDelivery;

    /**
     * 获取图片列表
     * @param listener
     */
    @Override
    public void loadVideoList(final OnLoadImageListListener listener) {

        String url = Urls.VIDEOS_URL;

        /*主线程*/
        mDelivery = new Handler(Looper.getMainLooper());

        mOkHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (Linux; Android 7.1; Nexus 6 Build/NDE63X) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/37.0.0.0 Mobile MQQBrowser/6.9 TBS/036903 Safari/537.36 MicroMessenger/6.5.3.980 NetType/WIFI Language/zh_CN")
                .build();

        Log.i("VIDEO", request.toString());

        Callback callback = new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {

                listener.onFailure("load video list failure.", e);

                Log.i("VIDEO", "加载失败");
            }

            @Override
            public void onResponse(Response response) throws IOException {

                int code = response.code();
                String res = response.body().string();

                Log.i("VIDEO", "网络取到的原始数据: " + res);

                if (code == 200) {

                    final List<VideoBean> videoBeanList = VideoJsonUtils.readJson2VideoBeans(res);

                    Log.i("VIDEO", "取到的数据: " + videoBeanList.toString());

                    /*在mainThread中执行*/
                    mDelivery.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onSuccess(videoBeanList);
                        }
                    });
                }
                else
                {
                    Log.i("VIDEO", code + res);
                }
            }
        };

        mOkHttpClient.newCall(request).enqueue(callback);
    }

    public interface OnLoadImageListListener {
        void onSuccess(List<VideoBean> list);
        void onFailure(String msg, Exception e);
    }
}
