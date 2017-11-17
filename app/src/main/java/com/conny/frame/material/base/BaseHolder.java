package com.conny.frame.material.base;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Desc:
 * Created by zhanghui on 2017/11/17.
 */

public class BaseHolder {
    public BaseHolder(View view) {
        ButterKnife.bind(this, view);
    }
}
