package com.conny.frame.test;

import com.conny.frame.api.ApiManager;
import com.conny.frame.api.RetrofitManager;
import com.conny.frame.api.service.FrameService;
import com.conny.frame.bean.ResultBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Desc:
 * Created by zhanghui on 2017/11/9.
 */

public class FrameApi {

    public static void mass(String format, Callback<IpBean> callback) {
        FrameService service = RetrofitManager.getRetrofit().create(FrameService.class);
        Call<IpBean> call = service.mass("iplookup", format);

        call.enqueue(callback);
    }

    public static void listIp(int page, int pageSize, Callback<ResultBean<IpBean>> callback) {
        FrameService service = RetrofitManager.getRetrofit().create(FrameService.class);
        Call<ResultBean<IpBean>> call = service.listIp(page, pageSize);

        call.enqueue(callback);
    }
}
