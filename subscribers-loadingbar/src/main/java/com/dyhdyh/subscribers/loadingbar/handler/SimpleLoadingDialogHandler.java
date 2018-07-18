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

    public SimpleLoadingDialogHandler(Context context) {
        this.mContext = context;
    }

    @Override
    public void show(CharSequence params) {
        if (TextUtils.isEmpty(params)) {
            LoadingDialog.make(mContext).show();
        } else {
            LoadingDialog.make(mContext).setMessage(params).show();
        }
    }

    @Override
    public void cancel() {
        LoadingDialog.cancel();
    }

}
