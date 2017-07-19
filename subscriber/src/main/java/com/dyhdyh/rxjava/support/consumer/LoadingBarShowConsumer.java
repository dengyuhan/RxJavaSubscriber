package com.dyhdyh.rxjava.support.consumer;

import android.util.Log;
import android.view.View;

import com.dyhdyh.rxjava.support.action.ILoadingShow;
import com.dyhdyh.rxjava.support.action.LoadingBarShowAction;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 显示LoadingBar
 * author  dengyuhan
 * created 2017/7/18 17:19
 */
public class LoadingBarShowConsumer implements Consumer<Disposable> {
    private ILoadingShow mAction;

    public LoadingBarShowConsumer(View parent) {
        this.mAction = new LoadingBarShowAction(parent);
    }

    @Override
    public void accept(@NonNull Disposable disposable) throws Exception {
        Log.d(Thread.currentThread().getName() + "-------------->", "doOnSubscribe----->");
        mAction.show(null);
    }

}
