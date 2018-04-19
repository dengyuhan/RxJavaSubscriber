package com.dyhdyh.subscribers.loadingbar.handler;

import android.content.Context;
import android.widget.Toast;

import com.dyhdyh.subscriber.handler.ErrorHandler;

/**
 * toast错误提示
 * @author dengyuhan
 *         created 2018/4/19 16:10
 */
public class SimpleToastErrorHandler implements ErrorHandler<String> {

    protected Context mContext;

    public SimpleToastErrorHandler(Context context) {
        this.mContext = context;
    }


    @Override
    public void showError(String errorParams, Throwable e) {
        Toast.makeText(mContext, errorParams, Toast.LENGTH_SHORT).show();
    }
}
