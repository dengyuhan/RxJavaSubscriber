package com.dyhdyh.subscribers.loadingbar.rxjava2;

import android.view.View;

import com.dyhdyh.subscriber.rxjava2.observer.CharSequenceObserver;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingBarErrorHandler;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingBarHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:20
 */
public class SimpleLoadingBarObserver<T> extends CharSequenceObserver<T> {

    public SimpleLoadingBarObserver(View parent) {
        this(parent, null);
    }

    public SimpleLoadingBarObserver(View parent, CharSequence errorMessage) {
        super(new SimpleLoadingBarHandler(parent), new SimpleLoadingBarErrorHandler(parent, errorMessage));
    }

}
