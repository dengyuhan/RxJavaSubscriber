package com.dyhdyh.subscriber.rxjava.subscriber;

import com.dyhdyh.subscriber.handler.ErrorHandler;
import com.dyhdyh.subscriber.handler.LoadingHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:31
 */
public class CharSequenceSubscriber<T> extends BaseSubscriber<T, CharSequence, CharSequence> {

    public CharSequenceSubscriber() {
    }

    public CharSequenceSubscriber(LoadingHandler<CharSequence> loadingHandler, ErrorHandler<CharSequence> errorHandler) {
        super(loadingHandler, errorHandler);
    }
}
