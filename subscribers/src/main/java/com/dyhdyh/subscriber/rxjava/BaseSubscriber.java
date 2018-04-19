package com.dyhdyh.subscriber.rxjava;

import com.dyhdyh.subscriber.handler.ErrorHandler;
import com.dyhdyh.subscriber.handler.LoadingHandler;

import rx.Subscriber;

/**
 * @author dengyuhan
 *         created 2018/4/19 15:41
 */
public class BaseSubscriber<T, LP, EP> extends Subscriber<T> {
    private LoadingHandler<LP> mLoadingHandler;
    private ErrorHandler<EP> mErrorHandler;

    public BaseSubscriber() {

    }

    public BaseSubscriber(LoadingHandler<LP> loadingHandler, ErrorHandler<EP> errorHandler) {
        this.mLoadingHandler = loadingHandler;
        this.mErrorHandler = errorHandler;
    }

    @Override
    public void onStart() {
        //显示loading
        if (mLoadingHandler != null) {
            mLoadingHandler.show(null);
        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        //取消loading
        if (mLoadingHandler != null) {
            mLoadingHandler.cancel();
        }
        //错误提示
        if (mErrorHandler != null) {
            mErrorHandler.showError(null, e);
        }
    }

    @Override
    public void onNext(T t) {
        //取消loading
        if (mLoadingHandler != null) {
            mLoadingHandler.cancel();
        }
    }
}
