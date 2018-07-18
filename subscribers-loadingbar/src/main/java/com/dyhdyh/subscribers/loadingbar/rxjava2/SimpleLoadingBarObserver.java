package com.dyhdyh.subscribers.loadingbar.rxjava2;

import android.view.View;

import com.dyhdyh.subscriber.handler.ErrorHandler;
import com.dyhdyh.subscriber.handler.LoadingHandler;
import com.dyhdyh.subscriber.rxjava2.observer.CharSequenceObserver;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingBarErrorHandler;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingBarHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:20
 */
public class SimpleLoadingBarObserver<T> extends CharSequenceObserver<T> {
    private View mParent;
    private CharSequence mDefaultMessage;

    public SimpleLoadingBarObserver(View parent) {
        this(parent, null);
    }

    public SimpleLoadingBarObserver(View parent, CharSequence errorMessage) {
        this.mParent = parent;
        this.mDefaultMessage = errorMessage;
    }


    @Override
    public LoadingHandler<CharSequence> createLoadingHandler() {
        return new SimpleLoadingBarHandler(mParent);
    }

    @Override
    public ErrorHandler<CharSequence> createErrorHandler() {
        return new SimpleLoadingBarErrorHandler(mParent);
    }

    @Override
    protected CharSequence buildErrorParams(Throwable e) {
        return mDefaultMessage;
    }
}
