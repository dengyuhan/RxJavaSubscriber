package com.dyhdyh.subscriber.transformer;

/**
 * @author dengyuhan
 *         created 2018/4/19 15:46
 */
public interface RxJavaTransformer<T> {
    void onStart();

    void onCompleted();

    void onError(Throwable e);

    void onNext(T t);
}
