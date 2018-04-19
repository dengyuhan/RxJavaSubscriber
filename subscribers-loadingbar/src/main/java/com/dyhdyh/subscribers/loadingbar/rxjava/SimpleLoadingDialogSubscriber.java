package com.dyhdyh.subscribers.loadingbar.rxjava;

import android.content.Context;

import com.dyhdyh.subscriber.rxjava.subscriber.CharSequenceSubscriber;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingDialogHandler;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleToastErrorHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:20
 */
public class SimpleLoadingDialogSubscriber<T> extends CharSequenceSubscriber<T> {

    public SimpleLoadingDialogSubscriber(Context context) {
        this(context, null, null);
    }

    public SimpleLoadingDialogSubscriber(Context context, CharSequence loadingMessage, CharSequence errorMessage) {
        super(new SimpleLoadingDialogHandler(context, loadingMessage), new SimpleToastErrorHandler(context, errorMessage));
    }

}
