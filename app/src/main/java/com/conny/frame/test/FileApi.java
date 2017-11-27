package com.conny.frame.test;

import com.conny.frame.api.RetrofitManager;
import com.conny.frame.api.loading.ProgressHandler;
import com.conny.frame.api.loading.ProgressListener;
import com.conny.frame.api.service.FileService;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2017/11/27 0027.
 */

public class FileApi {
    public static void download(Callback<ResponseBody> callback, ProgressHandler handler) {
        FileService fileService = RetrofitManager.getLoadingRetrofit(handler.getListener()).create(FileService.class);
        Call<ResponseBody> call = fileService.download();
        call.enqueue(callback);
    }
}
