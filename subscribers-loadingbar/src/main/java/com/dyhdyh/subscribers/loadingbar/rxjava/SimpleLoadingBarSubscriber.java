package com.dyhdyh.subscribers.loadingbar.rxjava;

import android.view.View;

import com.dyhdyh.subscriber.rxjava.subscriber.CharSequenceSubscriber;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingBarErrorHandler;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingBarHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:20
 */
public class SimpleLoadingBarSubscriber<T> extends CharSequenceSubscriber<T> {

    public SimpleLoadingBarSubscriber(View parent) {
        this(parent, null);
    }

    public SimpleLoadingBarSubscriber(View parent, CharSequence errorMessage) {
        super(new SimpleLoadingBarHandler(parent), new SimpleLoadingBarErrorHandler(parent, errorMessage));
    }

}
