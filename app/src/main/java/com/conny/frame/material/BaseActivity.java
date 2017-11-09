package com.conny.frame.material;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.conny.frame.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Desc:
 * Created by zhanghui on 2017/11/9.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private FrameLayout mContent;
    private Unbinder mBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mContent = (FrameLayout) findViewById(R.id.content);
        initLayout();
        mBinder = ButterKnife.bind(this);
        initData();
    }

    protected abstract void initLayout();

    protected abstract void initData();

    protected void addView(int layoutId) {
        View view = LayoutInflater.from(this).inflate(layoutId, null);
        mContent.addView(view);
    }

    @Override
    protected void onDestroy() {
        if (mBinder != null) {
            mBinder.unbind();
        }
        super.onDestroy();
    }
}
