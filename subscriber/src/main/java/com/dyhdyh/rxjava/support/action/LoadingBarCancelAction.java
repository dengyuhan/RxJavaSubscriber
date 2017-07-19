package com.dyhdyh.rxjava.support.action;

import android.view.View;

import com.dyhdyh.widget.loading.bar.LoadingBar;

/**
 * author  dengyuhan
 * created 2017/7/19 17:04
 */
public class LoadingBarCancelAction implements ILoadingCancel {
    protected View mParent;

    public LoadingBarCancelAction(View parent) {
        this.mParent = parent;
    }

    @Override
    public void cancel() {
        LoadingBar.cancel(mParent);
    }
}
