package com.conny.frame;

import android.view.View;
import android.widget.TextView;

import com.conny.frame.test.FrameApi;
import com.conny.frame.material.BaseActivity;
import com.conny.frame.test.IpBean;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.text)
    TextView mText;

    private final String URL = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json";

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
                req();
                break;
        }
    }

    private void req() {
        FrameApi.mass("json", new Callback<IpBean>() {
            @Override
            public void onResponse(Call<IpBean> call, Response<IpBean> response) {
                IpBean bean = response.body();
                if (bean != null) {
                    mText.setText(bean.country + " " + bean.city);
                }

            }

            @Override
            public void onFailure(Call<IpBean> call, Throwable t) {
                mText.setText("error");
            }
        });
    }
}
