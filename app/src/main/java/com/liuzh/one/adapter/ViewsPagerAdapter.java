package com.liuzh.one.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.liuzh.one.R;
import com.liuzh.one.activity.VideoActivity;

import java.util.List;

/**
 * images view pager adapter
 * Created by 刘晓彬 on 2017/3/30.
 */

public class ViewsPagerAdapter extends PagerAdapter {
    private static final String TAG = "ViewsPagerAdapter";
    private List<View> mImageViews;

    public ViewsPagerAdapter(final Context context, List<View> imageViews) {
        mImageViews = imageViews;
        View v = mImageViews.get(0);
        final String videoUrl = (String) v.getTag();
        if (!TextUtils.isEmpty(videoUrl)) {
            v.findViewById(R.id.iv_play).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VideoActivity.start(context, videoUrl);
                }
            });
        }
        Log.i(TAG, "ViewsPagerAdapter: " + mImageViews.size());
    }

    @Override
    public int getCount() {
        return mImageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//                container.removeView(mIVList.get(position % mIVList.size()));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mImageViews.get(position);
        ViewGroup parent = (ViewGroup) view.getParent();
        //如果当前要显示的view有父布局先将父布局移除（view只能有一个父布局）
        if (parent != null) {
            parent.removeView(view);
        }
        container.addView(view);
        return view;
    }
}