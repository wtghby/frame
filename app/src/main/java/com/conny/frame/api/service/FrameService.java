package com.conny.frame.api.service;

import com.conny.frame.test.IpBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Desc:
 * Created by zhanghui on 2017/11/9.
 */

public interface FrameService {

    @GET("{type}")
    Call<IpBean> mass(@Path("type") String type, @Query("format") String format);
}
