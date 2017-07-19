package com.dyhdyh.rxjava.support.action;

import android.content.Context;
import android.widget.Toast;

/**
 * author  dengyuhan
 * created 2017/7/19 17:43
 */
public class ToastShowErrorAction implements IErrorShow{
    protected Context mContext;

    public ToastShowErrorAction(Context context) {
        this.mContext = context;
    }

    @Override
    public void showError(CharSequence message, Throwable throwable) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
