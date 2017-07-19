package com.dyhdyh.rxjava.support;

import android.content.Context;
import android.view.View;

import com.dyhdyh.rxjava.support.action.LoadingBarCancelAction;
import com.dyhdyh.rxjava.support.action.LoadingDialogCancelAction;
import com.dyhdyh.rxjava.support.consumer.LoadingBarCancelConsumer;
import com.dyhdyh.rxjava.support.consumer.LoadingBarShowConsumer;
import com.dyhdyh.rxjava.support.consumer.LoadingDialogCancelConsumer;
import com.dyhdyh.rxjava.support.consumer.LoadingDialogShowConsumer;
import com.dyhdyh.rxjava.support.consumer.ToastShowErrorConsumer;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.LambdaObserver;

/**
 * author  dengyuhan
 * created 2017/7/19 18:21
 */
public class RxObserver {


    public static <T> Observer<T> loadingBar(View parent, Consumer<? super T> onNext) {
        return new LambdaObserver<T>(
                onNext,
                new ToastShowErrorConsumer(parent.getContext(), new LoadingBarCancelAction(parent)),
                new LoadingBarCancelConsumer(parent),
                new LoadingBarShowConsumer(parent)
        );
    }

    public static <T> Observer<T> loadingDialog(Context context, Consumer<? super T> onNext) {
        return new LambdaObserver<T>(
                onNext,
                new ToastShowErrorConsumer(context, new LoadingDialogCancelAction()),
                new LoadingDialogCancelConsumer(),
                new LoadingDialogShowConsumer(context)
        );
    }

}
