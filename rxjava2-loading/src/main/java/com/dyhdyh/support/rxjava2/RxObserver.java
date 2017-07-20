package com.dyhdyh.support.rxjava2;

import android.content.Context;
import android.view.View;

import com.dyhdyh.support.rxjava2.action.LoadingBarCancelAction;
import com.dyhdyh.support.rxjava2.action.LoadingDialogCancelAction;
import com.dyhdyh.support.rxjava2.consumer.LoadingBarShowConsumer;
import com.dyhdyh.support.rxjava2.consumer.LoadingDialogShowConsumer;
import com.dyhdyh.support.rxjava2.consumer.ToastShowErrorConsumer;
import com.dyhdyh.support.rxjava2.consumer.ViewErrorConsumer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.LambdaObserver;

/**
 * author  dengyuhan
 * created 2017/7/19 18:21
 */
public class RxObserver {


    public static <T> Observer<T> loadingBar(View parent, Consumer<T> onNext) {
        return new LambdaObserver<T>(
                onNext,
                new ViewErrorConsumer(parent),
                new LoadingBarCancelAction(parent),
                new LoadingBarShowConsumer(parent)
        );
    }

    public static <T> Observer<T> loadingDialog(Context context, Consumer<T> onNext) {
        return new LambdaObserver<T>(
                onNext,
                new ToastShowErrorConsumer(context),
                new LoadingDialogCancelAction(),
                new LoadingDialogShowConsumer(context)
        );
    }


    public static <T> Observer<T> lambda(Consumer<T> onNext, Consumer<Throwable> onError,
                                                Action onComplete,
                                                Consumer<Disposable> onSubscribe) {
        return new LambdaObserver<T>(onNext, onError, onComplete, onSubscribe);
    }


}
