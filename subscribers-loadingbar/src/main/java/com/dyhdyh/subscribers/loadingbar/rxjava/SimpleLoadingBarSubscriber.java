package com.dyhdyh.subscribers.loadingbar.rxjava;

import android.view.View;

import com.dyhdyh.subscriber.rxjava.StringSubscriber;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingBarErrorHandler;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingBarHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:20
 */
public class SimpleLoadingBarSubscriber<T> extends StringSubscriber<T> {

    public SimpleLoadingBarSubscriber(View parent) {
        super(new SimpleLoadingBarHandler(parent), new SimpleLoadingBarErrorHandler(parent));
    }

}
