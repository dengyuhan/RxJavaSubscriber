package com.dyhdyh.subscriber.rxjava;

import com.dyhdyh.subscriber.handler.ErrorHandler;
import com.dyhdyh.subscriber.handler.LoadingHandler;

/**
 * @author dengyuhan
 *         created 2018/4/19 16:31
 */
public class StringSubscriber<T> extends BaseSubscriber<T, String, String> {

    public StringSubscriber() {
    }

    public StringSubscriber(LoadingHandler<String> loadingHandler, ErrorHandler<String> errorHandler) {
        super(loadingHandler, errorHandler);
    }
}
