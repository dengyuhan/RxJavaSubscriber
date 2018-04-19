package com.dyhdyh.subscriber.rxjava2;

import com.dyhdyh.subscriber.transformer.RxJavaTransformer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author dengyuhan
 *         created 2018/4/19 15:41
 */
public class BaseObserver<T> implements Observer<T> {

    private RxJavaTransformer mTransformer;

    public BaseObserver(RxJavaTransformer transformer) {
        this.mTransformer = transformer;
    }

    @Override
    public void onSubscribe(Disposable d) {
        mTransformer.onStart();
    }

    @Override
    public void onComplete() {
        mTransformer.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        mTransformer.onError(e);
    }

    @Override
    public void onNext(T t) {
        mTransformer.onNext(t);
    }
}
