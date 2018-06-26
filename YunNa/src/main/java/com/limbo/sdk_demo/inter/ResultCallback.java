package com.limbo.sdk_demo.inter;

/**
 * Created by wangqi on 2018/5/4.
 */

public interface ResultCallback<T> {
    public abstract void onSuccess(T t);

    public abstract void onError(Throwable throwable);
}
