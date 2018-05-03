package com.dyhdyh.subscriber.rxjava2.observer;

import com.dyhdyh.subscriber.handler.ErrorHandler;
import com.dyhdyh.subscriber.handler.LoadingHandler;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author dengyuhan
 *         created 2018/4/19 15:41
 */
public class BaseObserver<T, LP, EP> implements Observer<T> {
    private LoadingHandler<LP> mLoadingHandler;
    private ErrorHandler<EP> mErrorHandler;

    public BaseObserver() {

    }

    public BaseObserver(LoadingHandler<LP> loadingHandler, ErrorHandler<EP> errorHandler) {
        this.mLoadingHandler = loadingHandler;
        this.mErrorHandler = errorHandler;
    }

    @Override
    public void onSubscribe(Disposable d) {
        //显示loading
        if (mLoadingHandler != null) {
            mLoadingHandler.show(null);
        }
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
    public void onComplete() {

    }


    @Override
    public void onNext(T t) {
        //取消loading
        if (mLoadingHandler != null) {
            mLoadingHandler.cancel();
        }
    }
}
