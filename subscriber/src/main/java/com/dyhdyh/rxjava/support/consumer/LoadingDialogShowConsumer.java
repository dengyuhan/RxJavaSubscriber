package com.dyhdyh.rxjava.support.consumer;

import android.content.Context;

import com.dyhdyh.rxjava.support.action.ILoadingShow;
import com.dyhdyh.rxjava.support.action.LoadingDialogShowAction;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 显示LoadingDialog
 * author  dengyuhan
 * created 2017/7/18 17:19
 */
public class LoadingDialogShowConsumer implements Consumer<Disposable> {
    private ILoadingShow mAction;
    private CharSequence mMessage;

    public LoadingDialogShowConsumer(Context context) {
        this(context, null);
    }

    public LoadingDialogShowConsumer(Context context, CharSequence message) {
        this.mAction = new LoadingDialogShowAction(context);
        this.mMessage = message;
    }

    @Override
    public void accept(@NonNull Disposable disposable) throws Exception {
        mAction.show(mMessage);
    }


}
