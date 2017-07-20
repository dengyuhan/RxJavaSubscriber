package com.dyhdyh.support.rxjava2.consumer;

import com.dyhdyh.support.rxjava2.action.LoadingShowAction;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public abstract class AbstractLoadingShowConsumer<Action extends LoadingShowAction> implements Consumer<Disposable> {
    private Action mAction;
    private Consumer<Action> mLoading;

    public AbstractLoadingShowConsumer(Action action, Consumer<Action> loading) {
        this.mAction = action;
        this.mLoading = loading;
    }

    @Override
    public void accept(@NonNull Disposable disposable) throws Exception {
        onSubscribe(disposable);
        if (mLoading != null) {
            mLoading.accept(mAction);
        }
    }

    public void onSubscribe(Disposable disposable) {

    }
}
