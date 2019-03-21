package com.dyhdyh.subscriber.rxjava2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author dengyuhan
 * created 2019/3/21 11:19
 */
public class SimpleObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
