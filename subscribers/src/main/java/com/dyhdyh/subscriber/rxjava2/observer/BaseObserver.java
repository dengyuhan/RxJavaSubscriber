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
        showLoading(null);
    }

    @Override
    public void onError(Throwable e) {
        if (isPrintStackTrace()){
            e.printStackTrace();
        }
        //取消loading
        cancelLoading();
        //错误提示
        showError(null, e);
    }

    @Override
    public void onComplete() {

    }


    @Override
    public void onNext(T t) {
        //取消loading
        cancelLoading();
    }


    public void showLoading(LP params) {
        if (mLoadingHandler != null) {
            mLoadingHandler.show(params);
        }
    }

    public void cancelLoading() {
        if (mLoadingHandler != null) {
            mLoadingHandler.cancel();
        }
    }

    public void showError(EP errorParams, Throwable e) {
        if (mErrorHandler != null) {
            mErrorHandler.showError(errorParams, e);
        }
    }


    public boolean isPrintStackTrace() {
        return true;
    }

    public LoadingHandler<LP> getLoadingHandler() {
        return mLoadingHandler;
    }

    public ErrorHandler<EP> getErrorHandler() {
        return mErrorHandler;
    }
}
