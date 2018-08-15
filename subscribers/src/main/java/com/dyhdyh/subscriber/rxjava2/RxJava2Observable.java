package com.dyhdyh.subscriber.rxjava2;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * author  dengyuhan
 * created 2017/7/18 17:56
 */
public class RxJava2Observable {

    public static <T> ObservableTransformer<T, T> io2main() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 创建一个异步任务
     * @param function
     * @return
     */
    public static <T> Observable<T> async(Function<Object, T> function) {
        return create(function).compose(io2main());
    }

    public static <T> Observable<T> next(T t) {
        return create(new Function<Object, T>() {
            @Override
            public T apply(Object aVoid) throws Exception {
                return t;
            }
        });
    }

    public static <T> Observable<T> create(Function<Object, T> function) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(function.apply(new Object()));
                } catch (Exception e) {
                    emitter.onError(e);
                }
                emitter.onComplete();
            }
        });
    }
}
