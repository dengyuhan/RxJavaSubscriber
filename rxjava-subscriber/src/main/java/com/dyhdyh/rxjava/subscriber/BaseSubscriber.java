package com.dyhdyh.rxjava.subscriber;

import rx.Subscriber;

/**
 * @author dengyuhan
 *         created 2018/4/19 15:09
 */
public class BaseSubscriber<T> extends Subscriber<T>{
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
