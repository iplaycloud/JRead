package com.iplay.jread.video.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iplay.jread.images.jokeimg.model.beans.ImageBean;
import com.iplay.jread.news.model.beans.NewsBean;
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

        System.out.println(res);

        try {

            JsonParser parser = new JsonParser();
            JsonObject jsonObj = parser.parse(res).getAsJsonObject();
            JsonElement jsonElement = jsonObj.get("V9LG4CHOR");
            if(jsonElement == null) {
                return null;
            }

            JsonArray jsonArray = jsonElement.getAsJsonArray();

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jo = jsonArray.get(i).getAsJsonObject();

                VideoBean video = JsonUtils.deserialize(jo, VideoBean.class);

                beans.add(video);
            }

        } catch (Exception e) {
            LogUtils.e(TAG, "readJsonVideoBeans error" , e);
        }

        return beans;
    }
}
