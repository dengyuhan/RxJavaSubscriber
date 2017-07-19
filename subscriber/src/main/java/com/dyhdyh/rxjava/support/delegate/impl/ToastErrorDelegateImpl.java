package com.dyhdyh.rxjava.support.delegate.impl;

import android.content.Context;
import android.widget.Toast;

import com.dyhdyh.rxjava.support.delegate.ErrorDelegate;

/**
 * Toast样式
 * author  dengyuhan
 * created 2017/7/18 17:46
 */
public class ToastErrorDelegateImpl implements ErrorDelegate {
    protected Context mContext;

    public ToastErrorDelegateImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void showError(CharSequence message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
