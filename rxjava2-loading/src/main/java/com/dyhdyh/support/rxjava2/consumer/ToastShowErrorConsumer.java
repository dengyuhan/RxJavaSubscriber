package com.dyhdyh.support.rxjava2.consumer;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.dyhdyh.support.rxjava2.RxGlobalConfig;
import com.dyhdyh.support.rxjava2.action.LoadingDialogCancelAction;

import io.reactivex.functions.BiConsumer;

/**
 * author  dengyuhan
 * created 2017/7/19 17:42
 */
public class ToastShowErrorConsumer extends ErrorConsumer {

    public ToastShowErrorConsumer(Context context) {
        this(new BiConsumer<CharSequence, Throwable>() {
            @Override
            public void accept(CharSequence message, Throwable throwable) throws Exception {
                if (TextUtils.isEmpty(message)) {
                    message = RxGlobalConfig.DEFAULT_SUBMIT_ERROR_MESSAGE;
                }
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public ToastShowErrorConsumer(BiConsumer<CharSequence, Throwable> errorConsumer) {
        super(new LoadingDialogCancelAction(), errorConsumer);
    }
}
