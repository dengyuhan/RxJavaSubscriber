package com.dyhdyh.support.rxjava2.consumer;

import android.text.TextUtils;
import android.view.View;

import com.dyhdyh.support.rxjava2.RxGlobalConfig;
import com.dyhdyh.support.rxjava2.action.LoadingBarCancelAction;
import com.dyhdyh.support.rxjava2.view.SimpleErrorLayout;
import com.dyhdyh.widget.loading.bar.LoadingBar;

import io.reactivex.functions.BiConsumer;

/**
 * 以View形式提示错误
 * author  dengyuhan
 * created 2017/7/20 14:53
 */
public class ViewErrorConsumer extends ErrorConsumer {

    public ViewErrorConsumer(View parent) {
        this(parent, new BiConsumer<CharSequence, Throwable>() {
            @Override
            public void accept(CharSequence message, Throwable throwable) throws Exception {
                if (TextUtils.isEmpty(message)) {
                    message = RxGlobalConfig.DEFAULT_LOADING_ERROR_MESSAGE;
                }
                LoadingBar.make(parent, SimpleErrorLayout.create(parent.getContext(), message)).show();
            }
        });
    }


    public ViewErrorConsumer(View parent, BiConsumer<CharSequence, Throwable> showError) {
        super(new LoadingBarCancelAction(parent), showError);
    }
}
