package com.dyhdyh.subscriber.rxjava2;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author dengyuhan
 * created 2019/3/20 16:11
 */
public class RxJava2Observer {

    @NonNull
    public static <T> Observer<T> create(@Nullable Consumer<Disposable> onSubscribe, @Nullable Consumer<T> onNext, @Nullable Consumer<Throwable> onError) {
        return create(onSubscribe, onNext, onError, null);
    }

    @NonNull
    public static <T> Observer<T> create(@Nullable Consumer<Disposable> onSubscribe, @Nullable Consumer<T> onNext, @Nullable Consumer<Throwable> onError, @Nullable Action onComplete) {
        return new Observer<T>() {
            @Override
            public void onSubscribe(Disposable d) {
                try {
                    if (onSubscribe != null) {
                        onSubscribe.accept(d);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNext(T t) {
                try {
                    if (onNext != null) {
                        onNext.accept(t);
                    }
                } catch (Exception e) {
                    this.onError(e);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                try {
                    if (onError != null) {
                        onError.accept(throwable);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onComplete() {
                try {
                    if (onComplete != null) {
                        onComplete.run();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
    }

    public static <T> Observer<T> noImpl() {
        return new Observer<T>() {
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

        };
    }

}
