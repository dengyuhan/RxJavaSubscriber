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

    public SimpleLoadingBarErrorHandler(View parent) {
        this.mParent = parent;
    }

    @Override
    public void showError(CharSequence errorParams, Throwable e) {
        if (!TextUtils.isEmpty(errorParams)){
            LoadingBar.make(mParent, SimpleErrorLayout.create(mParent.getContext(), errorParams)).show();
        }
    }
}
