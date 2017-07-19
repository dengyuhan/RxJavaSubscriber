package com.dyhdyh.rxjava.support.delegate.impl;

import android.content.Context;

import com.dyhdyh.rxjava.support.delegate.LoadingDelegate;
import com.dyhdyh.widget.loading.dialog.LoadingDialog;

/**
 * LoadingDialog样式
 * author  dengyuhan
 * created 2017/7/18 17:43
 */
public class LoadingDialogDelegateImpl implements LoadingDelegate{
    protected Context mContext;

    public LoadingDialogDelegateImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void show(CharSequence message) {
        LoadingDialog.make(mContext).setMessage(message).show();
    }

    @Override
    public void cancel() {
        LoadingDialog.cancel();
    }
}
