package com.conny.frame.test;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.conny.frame.R;
import com.conny.frame.material.base.BaseFragment;

import butterknife.BindView;

/**
 * Desc:
 * Created by zhanghui on 2017/11/17.
 */

public class LazyFragment extends BaseFragment {

    @BindView(R.id.title)
    TextView mTitle;

    private int id;

    @Override
    public View getContainerView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_lazy_fragment, null);
        return view;
    }

    @Override
    public void initData() {
        mTitle.setText("Lazy---" + id);
    }

    public void setId(int id) {
        this.id = id;
    }
}
