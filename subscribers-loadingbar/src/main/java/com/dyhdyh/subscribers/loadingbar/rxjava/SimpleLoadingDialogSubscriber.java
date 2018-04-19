package com.dyhdyh.subscribers.loadingbar.rxjava;

import android.content.Context;

import com.dyhdyh.subscriber.rxjava.StringSubscriber;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingDialogHandler;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleToastErrorHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:20
 */
public class SimpleLoadingDialogSubscriber<T> extends StringSubscriber<T> {

    public SimpleLoadingDialogSubscriber(Context context) {
        super(new SimpleLoadingDialogHandler(context), new SimpleToastErrorHandler(context));
    }

}
