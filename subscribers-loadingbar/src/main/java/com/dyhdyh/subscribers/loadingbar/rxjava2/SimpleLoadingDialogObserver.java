package com.dyhdyh.subscribers.loadingbar.rxjava2;

import android.content.Context;

import com.dyhdyh.subscriber.handler.ErrorHandler;
import com.dyhdyh.subscriber.handler.LoadingHandler;
import com.dyhdyh.subscriber.rxjava2.observer.CharSequenceObserver;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingDialogHandler;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleToastErrorHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:20
 */
public class SimpleLoadingDialogObserver<T> extends CharSequenceObserver<T> {

    private Context mContext;
    private CharSequence mDefaultMessage;
    private CharSequence mDefaultErrorMessage;

    public SimpleLoadingDialogObserver(Context context) {
        this(context, null, null);
    }

    public SimpleLoadingDialogObserver(Context context, CharSequence loadingMessage, CharSequence errorMessage) {
        this.mContext = context;
        this.mDefaultMessage = loadingMessage;
        this.mDefaultErrorMessage = errorMessage;
    }

    @Override
    public LoadingHandler<CharSequence> createLoadingHandler() {
        return new SimpleLoadingDialogHandler(mContext);
    }

    @Override
    public ErrorHandler<CharSequence> createErrorHandler() {
        return new SimpleToastErrorHandler(mContext);
    }

    @Override
    protected CharSequence buildLoadingParams() {
        return mDefaultMessage;
    }

    @Override
    protected CharSequence buildErrorParams(Throwable e) {
        return mDefaultErrorMessage;
    }

}
