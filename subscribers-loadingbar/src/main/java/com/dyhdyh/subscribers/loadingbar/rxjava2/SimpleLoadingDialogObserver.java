package com.dyhdyh.subscribers.loadingbar.rxjava2;

import android.content.Context;

import com.dyhdyh.subscriber.rxjava2.observer.CharSequenceObserver;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleLoadingDialogHandler;
import com.dyhdyh.subscribers.loadingbar.handler.SimpleToastErrorHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:20
 */
public class SimpleLoadingDialogObserver<T> extends CharSequenceObserver<T> {

    public SimpleLoadingDialogObserver(Context context) {
        this(context, null, null);
    }

    public SimpleLoadingDialogObserver(Context context, CharSequence loadingMessage, CharSequence errorMessage) {
        super(new SimpleLoadingDialogHandler(context, loadingMessage), new SimpleToastErrorHandler(context, errorMessage));
    }

}
