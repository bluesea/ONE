package com.liuzh.one.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuzh.one.R;

/**
 * 自定义的Toolbar
 * Created by 刘晓彬 on 2017/3/23.
 */

public class AppToolbar extends Toolbar {

    private ImageView mIvLBtn;
    private ImageView mIvRLBtn;
    private ImageView mIvRRBtn;
    private TextView mTvTitle;

    public AppToolbar(Context context) {
        this(context, null, 0);
    }

    public AppToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AppToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = View.inflate(context, R.layout.layout_toolbar_content, this);
        mIvLBtn = (ImageView) view.findViewById(R.id.iv_toolbar_left);
        mTvTitle = (TextView) view.findViewById(R.id.tv_toolbar_title);
        mIvRLBtn = (ImageView) view.findViewById(R.id.iv_toolbar_right_l);
        mIvRRBtn = (ImageView) findViewById(R.id.iv_toolbar_right_r);
        setBackgroundResource(R.color.toolbar);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        setPadding(0, 0, 0, 0);
    }

    public void setToolbarTitle(String title) {
        mTvTitle.setText(title);
    }

    public void setLBtnDrawable(int resId) {
        mIvLBtn.setImageResource(resId);
    }

    public void setLBtnClickListener(OnClickListener listener) {
        mIvLBtn.setOnClickListener(listener);
    }

    public void setRLDrawable(int resId) {
        mIvRLBtn.setImageResource(resId);
    }

    public void setRLClickListener(OnClickListener listener) {
        mIvRLBtn.setOnClickListener(listener);
    }

    public void setRRDrawable(int resId) {
        mIvRRBtn.setImageResource(resId);
    }

    public void setRRClickListener(OnClickListener listener) {
        mIvRRBtn.setOnClickListener(listener);
    }

    public TextView getTvTitle() {
        return mTvTitle;
    }
}