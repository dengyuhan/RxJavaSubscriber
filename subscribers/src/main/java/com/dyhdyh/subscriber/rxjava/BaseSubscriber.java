package com.dyhdyh.subscriber.rxjava;

import rx.Subscriber;

/**
 * @author dengyuhan
 *         created 2018/4/19 15:41
 */
public class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onStart() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
