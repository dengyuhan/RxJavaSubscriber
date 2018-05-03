package com.dyhdyh.subscriber.rxjava2.observer;

import com.dyhdyh.subscriber.handler.ErrorHandler;
import com.dyhdyh.subscriber.handler.LoadingHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:31
 */
public class CharSequenceObserver<T> extends BaseObserver<T, CharSequence, CharSequence> {

    public CharSequenceObserver() {
    }

    public CharSequenceObserver(LoadingHandler<CharSequence> loadingHandler, ErrorHandler<CharSequence> errorHandler) {
        super(loadingHandler, errorHandler);
    }
}
