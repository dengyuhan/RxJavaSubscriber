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
 * @author dengyuhan
 * created 2019/3/18 14:28
 */
public abstract class LoadingObservableTransformer<T> implements ObservableTransformer<T, T> {

    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(getShowConsumer())
                .doOnError(getErrorConsumer())
                .doFinally(getCancelAction());
    }

    @NonNull
    protected abstract Consumer<Disposable> getShowConsumer();

    @NonNull
    protected abstract Consumer<Throwable> getErrorConsumer();

    @NonNull
    protected abstract Action getCancelAction();
}
