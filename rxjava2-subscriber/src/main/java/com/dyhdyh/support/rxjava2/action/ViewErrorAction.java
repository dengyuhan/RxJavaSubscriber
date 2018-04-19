package com.dyhdyh.support.rxjava2.action;

import android.view.View;

import com.dyhdyh.support.rxjava2.view.SimpleErrorLayout;
import com.dyhdyh.widget.loading.bar.LoadingBar;

/**
 * author  dengyuhan
 * created 2017/7/20 14:54
 */
public class ViewErrorAction implements ErrorShowAction {
    protected View mParent;

    public ViewErrorAction(View parent) {
        this.mParent = parent;
    }

    @Override
    public void showError(CharSequence message, Throwable throwable) {
        LoadingBar.make(mParent, SimpleErrorLayout.create(mParent.getContext(), message)).show();
    }
}
