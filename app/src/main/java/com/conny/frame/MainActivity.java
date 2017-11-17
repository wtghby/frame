package com.conny.frame;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.conny.frame.material.BaseActivity;
import com.conny.frame.material.dialog.CommonDialog;
import com.conny.library.slidingmenu.lib.SlidingMenu;
import com.conny.frame.test.FrameApi;
import com.conny.frame.test.IpBean;
import com.conny.frame.test.PullActivity;

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

    private SlidingMenu menu;

    private final String URL = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json";
    private final String PIC = "http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg";

    @Override
    protected void initLayout() {
        addView(R.layout.activity_main);
        initMenu();
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
                sliding();
//                showDialog();
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
        Intent intent = new Intent(this, PullActivity.class);
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

    private void sliding() {
        if (menu == null)
            return;
        menu.setSlidingEnabled(true);
        menu.toggle();
    }

    private void initMenu() {
        if (menu == null) {
            menu = new SlidingMenu(this);
            menu.setMode(SlidingMenu.LEFT);
            menu.setSlidingEnabled(false);
            menu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
            menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
            menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
            menu.setMenu(R.layout.layout_home_sliding);
            menu.setOffsetFadeDegree(0.25f);
            menu.setFadeDegree(0.35f);
            menu.setShadowWidth(15);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (menu != null && menu.isMenuShowing()) {
                menu.toggle();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
