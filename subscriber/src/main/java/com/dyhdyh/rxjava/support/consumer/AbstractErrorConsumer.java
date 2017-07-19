package com.dyhdyh.rxjava.support.consumer;

import com.dyhdyh.rxjava.support.action.ILoadingCancel;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Error
 * author  dengyuhan
 * created 2017/7/18 17:19
 */
public abstract class AbstractErrorConsumer implements Consumer<Throwable>{
    private ILoadingCancel mLoadingCancelAction;

    public AbstractErrorConsumer(ILoadingCancel loadingCancelAction) {
        this.mLoadingCancelAction = loadingCancelAction;
    }

    @Override
    public void accept(@NonNull Throwable throwable) throws Exception {
        mLoadingCancelAction.cancel();
    }
}
