package com.iplay.jread.img.home;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.iplay.jread.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import com.iplay.jread.img.data.bean.GirlsBean;

/**
 * viewholder
 */
public class GirlsViewHolder extends BaseViewHolder<GirlsBean.ResultsEntity> {

    private ImageView image;

    public GirlsViewHolder(ViewGroup parent) {
        super(parent, R.layout.img_item_girl);
        image = $(R.id.girl_img);
    }

    @Override
    public void setData(GirlsBean.ResultsEntity data) {
        super.setData(data);
        Glide.with(getContext())
                .load(data.getUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image);
    }
}
