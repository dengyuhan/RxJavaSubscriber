package com.dyhdyh.subscriber.handler;

/**
 * @author dengyuhan
 *         created 2018/4/19 15:18
 */
public interface LoadingHandler<T> {

    void show(T params);

    void cancel();

}
