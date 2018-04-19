package com.dyhdyh.subscriber.rxjava;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author  dengyuhan
 * created 2017/7/18 17:56
 */
public class RxJavaSchedulers<T> {

    public static <T> Observable.Transformer<T, T> io2main() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
