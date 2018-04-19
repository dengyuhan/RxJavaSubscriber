package com.dyhdyh.subscribers.loadingbar.handler;

import android.text.TextUtils;
import android.view.View;

import com.dyhdyh.subscriber.handler.ErrorHandler;
import com.dyhdyh.subscribers.loadingbar.view.SimpleErrorLayout;
import com.dyhdyh.widget.loading.bar.LoadingBar;

/**
 * view样式的错误提示
 *
 * @author dengyuhan
 *         created 2018/4/19 16:10
 */
public class SimpleLoadingBarErrorHandler implements ErrorHandler<CharSequence> {
    protected View mParent;
    private CharSequence mMessage;

    public SimpleLoadingBarErrorHandler(View parent) {
        this(parent, null);
    }

    public SimpleLoadingBarErrorHandler(View parent, CharSequence message) {
        this.mParent = parent;
        this.mMessage = message;
    }

    @Override
    public void showError(CharSequence errorParams, Throwable e) {
        CharSequence message = TextUtils.isEmpty(errorParams) ? mMessage : errorParams;
        LoadingBar.make(mParent, SimpleErrorLayout.create(mParent.getContext(), message)).show();
    }
}
