package com.conny.frame.api.loading;

/**
 * Created by Administrator on 2017/11/27 0027.
 */

public interface ProgressListener {
    /**
     * @param progress 已经下载或上传字节数
     * @param total    总字节数
     * @param done     是否完成
     */
    void onProgress(long progress, long total, boolean done);
}
