package com.conny.frame.test;

import com.conny.frame.R;
import com.conny.frame.material.base.BaseActivity;
import com.conny.library.pulltorefresh.pulltorefresh.PullToRefreshSwipeListView;

import butterknife.BindView;

/**
 * Desc:
 * Created by zhanghui on 2017/11/17.
 */

public class PullActivity extends BaseActivity {

    @BindView(R.id.pull_refresh_list)
    PullToRefreshSwipeListView mList;

    private SwipeAdapter mAdapter;

    @Override
    protected void initLayout() {
        addView(R.layout.activity_ptr_list);
    }

    @Override
    protected void initData() {
        mAdapter = new SwipeAdapter(this, mList);
        mList.setAdapter(mAdapter);
    }
}
