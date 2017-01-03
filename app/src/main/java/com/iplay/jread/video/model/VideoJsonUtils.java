package com.iplay.jread.video.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iplay.jread.images.jokeimg.model.beans.ImageBean;
import com.iplay.jread.utils.JsonUtils;
import com.iplay.jread.utils.LogUtils;
import com.iplay.jread.video.model.beans.VideoBean;
import com.iplay.jread.video.model.beans.VideosBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/23
 */
public class VideoJsonUtils {

    private final static String TAG = "VideoJsonUtils";
    /**
     * 将获取到的json转换为图片列表对象
     * @param res
     * @return
     */
    public static List<VideoBean> readJson2VideoBeans(String res) {
        List<VideoBean> beans = new ArrayList<VideoBean>();

        Log.i("JSON", res);

        Gson gson = new Gson();
        VideosBean mVideosBean = (VideosBean)gson.fromJson(res, VideosBean.class);

        return mVideosBean.getmVideoBean();
    }
}
