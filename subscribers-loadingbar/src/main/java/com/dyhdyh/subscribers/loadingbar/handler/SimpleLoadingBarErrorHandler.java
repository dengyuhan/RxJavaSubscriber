package com.dyhdyh.subscribers.loadingbar.handler;

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
public class SimpleLoadingBarErrorHandler implements ErrorHandler<String> {
    protected View mParent;

    public SimpleLoadingBarErrorHandler(View parent) {
        this.mParent = parent;
    }

    @Override
    public void showError(String errorParams, Throwable e) {
        LoadingBar.make(mParent, SimpleErrorLayout.create(mParent.getContext(), errorParams)).show();
    }
}
