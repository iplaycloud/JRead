package com.iplay.jread.video.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iplay.jread.R;
import com.iplay.jread.video.model.beans.VideoBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/19
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ItemViewHolder> {

    private List<VideoBean> mData;
    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public VideoAdapter(Context context) {
        this.mContext = context;
    }

    public void setmDate(List<VideoBean> data) {
        this.mData = data;

//        System.out.println(data.toString());

        this.notifyDataSetChanged();
    }

    @Override
    public VideoAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_video, parent, false);

        ItemViewHolder vh = new ItemViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(VideoAdapter.ItemViewHolder holder, int position) {

        VideoBean videoBean = mData.get(position);
        if (videoBean == null) {
            return;
        }

        holder.videoplayer.setUp(videoBean.getMp4_url(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, videoBean.getTitle());
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    public VideoBean getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public JCVideoPlayerStandard videoplayer;

        public ItemViewHolder(View v) {
            super(v);
            videoplayer = (JCVideoPlayerStandard) v.findViewById(R.id.videoplayer);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getPosition());
            }
        }
    }
}
