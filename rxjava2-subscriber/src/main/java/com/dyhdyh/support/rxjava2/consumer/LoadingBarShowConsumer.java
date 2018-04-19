package com.dyhdyh.support.rxjava2.consumer;

import android.view.View;

import com.dyhdyh.support.rxjava2.RxGlobalConfig;
import com.dyhdyh.support.rxjava2.action.LoadingBarShowAction;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * 显示LoadingBar
 * author  dengyuhan
 * created 2017/7/18 17:19
 */
public class LoadingBarShowConsumer extends LoadingShowConsumer<LoadingBarShowAction> {

    public LoadingBarShowConsumer(View parent) {
        this(parent, new Consumer<LoadingBarShowAction>() {
            @Override
            public void accept(@NonNull LoadingBarShowAction loading) throws Exception {
                loading.show(RxGlobalConfig.DEFAULT_LOADING_MESSAGE);
            }
        });
    }

    public LoadingBarShowConsumer(View parent, Consumer<LoadingBarShowAction> loading) {
        super(new LoadingBarShowAction(parent), loading);
    }
}
