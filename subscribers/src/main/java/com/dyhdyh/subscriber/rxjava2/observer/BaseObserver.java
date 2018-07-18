package com.dyhdyh.subscriber.rxjava2.observer;

import com.dyhdyh.subscriber.handler.ErrorHandler;
import com.dyhdyh.subscriber.handler.LoadingHandler;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author dengyuhan
 *         created 2018/4/19 15:41
 */
public abstract class BaseObserver<T, LP, EP> implements Observer<T> {
    private LoadingHandler<LP> mLoadingHandler;
    private ErrorHandler<EP> mErrorHandler;

    public BaseObserver() {

    }

    public abstract LoadingHandler<LP> createLoadingHandler();

    public abstract ErrorHandler<EP> createErrorHandler();

    @Override
    public void onSubscribe(Disposable d) {
        //显示loading
        showLoading(buildLoadingParams(), getLoadingHandler());
    }

    @Override
    public void onError(Throwable e) {
        if (isPrintStackTrace()) {
            e.printStackTrace();
        }
        //取消loading
        cancelLoading(getLoadingHandler());
        //错误提示
        showError(buildErrorParams(e), e, getErrorHandler());
    }


    @Override
    public void onComplete() {

    }


    @Override
    public void onNext(T t) {
        //取消loading
        cancelLoading(getLoadingHandler());
    }


    public void showLoading(LP params, LoadingHandler<LP> handler) {
        if (handler != null) {
            handler.show(params);
        }
    }

    public void cancelLoading(LoadingHandler<LP> handler) {
        if (handler != null) {
            handler.cancel();
        }
    }


    protected LP buildLoadingParams() {
        return null;
    }

    public void showError(EP errorParams, Throwable e, ErrorHandler<EP> handler) {
        if (handler != null) {
            handler.showError(errorParams, e);
        }
    }

    protected EP buildErrorParams(Throwable e) {
        return null;
    }


    public boolean isPrintStackTrace() {
        return true;
    }

    public LoadingHandler<LP> getLoadingHandler() {
        if (mLoadingHandler == null) {
            mLoadingHandler = this.createLoadingHandler();
        }
        return mLoadingHandler;
    }

    public ErrorHandler<EP> getErrorHandler() {
        if (mErrorHandler == null) {
            mErrorHandler = this.createErrorHandler();
        }
        return mErrorHandler;
    }
}
