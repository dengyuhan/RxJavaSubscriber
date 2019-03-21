package com.dyhdyh.subscribers.loadingbar;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * 正常 doOnSubscribe(show) -> doOnNext(cancel)
 * 异常 doOnSubscribe(show) -> doOnError(cancel)
 * onNext出现异常 doOnSubscribe(show) -> doOnNext(cancel)
 * @author dengyuhan
 * created 2019/3/18 14:28
 */
public abstract class LoadingTransformer<T> implements ObservableTransformer<T, T> {

    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(showLoadingConsumer())
                .doOnNext(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        cancelLoadingAction().run();
                    }
                })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        cancelLoadingAction().run();
                        showErrorConsumer().accept(throwable);
                    }
                });
    }

    @NonNull
    protected abstract Consumer<Disposable> showLoadingConsumer();

    @NonNull
    protected abstract Consumer<Throwable> showErrorConsumer();

    @NonNull
    protected abstract Action cancelLoadingAction();
}
