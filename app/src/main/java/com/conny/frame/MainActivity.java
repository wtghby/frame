package com.conny.frame;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.conny.frame.material.dialog.CommonDialog;
import com.conny.frame.test.FrameApi;
import com.conny.frame.material.BaseActivity;
import com.conny.frame.test.IpBean;
import com.conny.frame.test.PullToRefreshSwipeListActivity;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.image)
    ImageView mImage;

    private final String URL = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json";
    private final String PIC = "http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg";

    @Override
    protected void initLayout() {
        addView(R.layout.activity_main);
    }

    @Override
    protected void initData() {
        mText.setText("hhhhhhhhhhhhh");
        Glide.with(this)
                .load(PIC)
                .into(mImage);
    }

    @OnClick({R.id.click})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.click:
//                req();
//                pull();
                showDialog();
//                showProgress(true);
                break;
        }
    }

    private void showDialog() {
//        LoadingUtils.show(this);
        final CommonDialog dialog = new CommonDialog(this, "dasdsdasssd", "title");
        dialog.setNegativeButton(R.string.yes, new CommonDialog.DialogOnClickListener() {
            @Override
            public void onClick() {
                dialog.dismiss();
            }
        });

        dialog.setPositiveButton(R.string.no, new CommonDialog.DialogOnClickListener() {
            @Override
            public void onClick() {
                dialog.dismiss();
            }
        });
//        dialog.set
        dialog.show();
    }

    private void pull() {
        Intent intent = new Intent(this, PullToRefreshSwipeListActivity.class);
        startActivity(intent);
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
