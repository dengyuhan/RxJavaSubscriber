package com.dyhdyh.subscribers.loadingbar.handler;

import android.content.Context;
import android.text.TextUtils;

import com.dyhdyh.subscriber.handler.LoadingHandler;
import com.dyhdyh.widget.loading.dialog.LoadingDialog;

/**
 * dialog样式的loading
 *
 * @author dengyuhan
 *         created 2018/4/19 15:29
 */
public class SimpleLoadingDialogHandler implements LoadingHandler<CharSequence> {
    protected Context mContext;
    private CharSequence mMessage;

    public SimpleLoadingDialogHandler(Context context) {
        this(context, null);
    }

    public SimpleLoadingDialogHandler(Context context, CharSequence message) {
        this.mContext = context;
        this.mMessage = message;
    }

    @Override
    public void show(CharSequence params) {
        LoadingDialog.make(mContext).setMessage(TextUtils.isEmpty(params) ? mMessage : params).show();
    }

    @Override
    public void cancel() {
        LoadingDialog.cancel();
    }

}
