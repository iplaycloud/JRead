package com.iplay.jread.images.jokeimg.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iplay.jread.R;
import com.iplay.jread.images.jokeimg.model.beans.ImageBean;
import com.iplay.jread.images.jokeimg.model.ImageAdapter;
import com.iplay.jread.images.jokeimg.presenter.ImagePresenter;
import com.iplay.jread.images.jokeimg.presenter.ImagePresenterImpl;
import com.iplay.jread.images.jokeimg.view.IImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 15/12/22
 */
public class ImagesListFragment extends Fragment implements IImageView, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "ImagesListFragment";

    @BindView(R.id.swipe_refresh_widget)
    SwipeRefreshLayout mSwipeRefreshWidget;

    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;

    private LinearLayoutManager mLayoutManager;

    private ImageAdapter mAdapter;
    private List<ImageBean> mData;
    private ImagePresenter mImagePresenter;

    public static ImagesListFragment newInstance(int type) {
        Bundle args = new Bundle();
        ImagesListFragment fragment = new ImagesListFragment();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImagePresenter = new ImagePresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image, null);

        ButterKnife.bind(this, view);

        initView();

        onRefresh();

        return view;
    }

    private void initView() {

        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
                R.color.primary_dark, R.color.primary_light,
                R.color.accent);
        mSwipeRefreshWidget.setOnRefreshListener(this);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ImageAdapter(getActivity().getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

            super.onScrollStateChanged(recyclerView, newState);

            if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItem + 1 == mAdapter.getItemCount() ) {
                //加载更多
                Snackbar.make(getActivity().findViewById(R.id.drawer_layout), getString(R.string.image_hit), Snackbar.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onRefresh() {
        mImagePresenter.loadImageList();
    }

    @Override
    public void addImages(List<ImageBean> list) {
        if(mData == null) {
            mData = new ArrayList<>();
        }
        mData.clear();
        mData.addAll(list);
        mAdapter.setmDate(mData);
    }

    @Override
    public void showProgress() {
        mSwipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void showLoadFailMsg() {
        if (isAdded()) {
            View view = getActivity() == null ? mRecyclerView.getRootView() : getActivity().findViewById(R.id.drawer_layout);
            Snackbar.make(view, getString(R.string.load_fail), Snackbar.LENGTH_SHORT).show();
        }
    }
}