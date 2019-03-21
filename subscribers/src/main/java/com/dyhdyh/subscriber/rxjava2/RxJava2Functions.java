package com.dyhdyh.subscriber.rxjava2;

import io.reactivex.functions.Consumer;

/**
 * @author dengyuhan
 * created 2019/3/20 16:11
 */
public class RxJava2Functions {

    public static <T> Consumer<T> noImpl() {
        return new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {

            }
        };
    }

    public static Consumer<Throwable> onErrorNoImpl() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        };
    }
}
