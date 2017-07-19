package com.dyhdyh.rxjava.support.consumer;

import android.content.Context;

import com.dyhdyh.rxjava.support.action.IErrorShow;
import com.dyhdyh.rxjava.support.action.ILoadingCancel;
import com.dyhdyh.rxjava.support.action.ToastShowErrorAction;

import io.reactivex.annotations.NonNull;

/**
 * author  dengyuhan
 * created 2017/7/19 17:42
 */
public class ToastShowErrorConsumer extends AbstractErrorConsumer {
    private IErrorShow mAction;
    private CharSequence mMessage;

    public ToastShowErrorConsumer(Context context, ILoadingCancel loadingCancelAction) {
        this(context, null, loadingCancelAction);
    }

    public ToastShowErrorConsumer(Context context, CharSequence message, ILoadingCancel loadingCancelAction) {
        super(loadingCancelAction);
        this.mAction = new ToastShowErrorAction(context);
        this.mMessage = message;
    }

    @Override
    public void accept(@NonNull Throwable throwable) throws Exception {
        super.accept(throwable);
        mAction.showError(mMessage, throwable);
    }
}
