package com.conny.frame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.conny.frame.material.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.text)
    TextView mText;

    @Override
    protected void initLayout() {
        addView(R.layout.activity_main);
    }

    @Override
    protected void initData() {
        mText.setText("hhhhhhhhhhhhh");
    }

    @OnClick({R.id.click})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.click:
                mText.setText("Click");
                break;
        }
    }
}
