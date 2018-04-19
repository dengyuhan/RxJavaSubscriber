package com.dyhdyh.subscribers.loadingbar.handler;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.dyhdyh.subscriber.handler.ErrorHandler;

/**
 * toast错误提示
 *
 * @author dengyuhan
 *         created 2018/4/19 16:10
 */
public class SimpleToastErrorHandler implements ErrorHandler<CharSequence> {

    protected Context mContext;
    private CharSequence mMessage;

    public SimpleToastErrorHandler(Context context) {
        this(context, null);
    }

    public SimpleToastErrorHandler(Context context, CharSequence message) {
        this.mContext = context;
        this.mMessage = message;
    }

    @Override
    public void showError(CharSequence errorParams, Throwable e) {
        CharSequence message = TextUtils.isEmpty(errorParams) ? mMessage : errorParams;
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
