package com.dyhdyh.support.rxjava2.consumer;

import android.content.Context;

import com.dyhdyh.support.rxjava2.RxGlobalConfig;
import com.dyhdyh.support.rxjava2.action.LoadingDialogShowAction;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * 显示LoadingDialog
 * author  dengyuhan
 * created 2017/7/18 17:19
 */
public class LoadingDialogShowConsumer extends LoadingShowConsumer<LoadingDialogShowAction> {


    public LoadingDialogShowConsumer(Context context) {
        this(context, new Consumer<LoadingDialogShowAction>() {
            @Override
            public void accept(@NonNull LoadingDialogShowAction loading) throws Exception {
                loading.show(RxGlobalConfig.DEFAULT_SUBMIT_LOADING_MESSAGE);
            }
        });
    }

    public LoadingDialogShowConsumer(Context context, Consumer<LoadingDialogShowAction> loading) {
        super(new LoadingDialogShowAction(context), loading);
    }


}
