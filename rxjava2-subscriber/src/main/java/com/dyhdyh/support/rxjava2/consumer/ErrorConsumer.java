package com.dyhdyh.support.rxjava2.consumer;

import com.dyhdyh.support.rxjava2.RxGlobalConfig;
import com.dyhdyh.support.rxjava2.action.LoadingCancelAction;

import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

/**
 * Error
 * author  dengyuhan
 * created 2017/7/18 17:19
 */
public abstract class ErrorConsumer implements Consumer<Throwable> {

    private BiConsumer<CharSequence, Throwable> mErrorConsumer;
    private LoadingCancelAction mCancelAction;

    public ErrorConsumer(LoadingCancelAction cancelAction, BiConsumer<CharSequence, Throwable> errorConsumer) {
        this.mCancelAction = cancelAction;
        this.mErrorConsumer = errorConsumer;
    }

    @Override
    public void accept(@NonNull Throwable throwable) throws Exception {
        if (mCancelAction != null) {
            mCancelAction.cancel();
        }
        onError(throwable);
    }

    public void onError(Throwable throwable) throws Exception {
        CharSequence message = null;
        if (throwable instanceof UnknownHostException) {
            message = RxGlobalConfig.DEFAULT_ERROR_NETWORK_MESSAGE;
        } else if (throwable instanceof TimeoutException) {
            message = RxGlobalConfig.DEFAULT_ERROR_TIMEOUT_MESSAGE;
        }
        if (mErrorConsumer != null) {
            mErrorConsumer.accept(message, throwable);
        }
    }
}
