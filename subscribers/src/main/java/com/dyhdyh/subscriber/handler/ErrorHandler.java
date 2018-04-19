package com.dyhdyh.subscriber.handler;

/**
 * @author dengyuhan
 *         created 2018/4/19 15:33
 */
public interface ErrorHandler<T> {

    void showError(T errorParams, Throwable e);

}
