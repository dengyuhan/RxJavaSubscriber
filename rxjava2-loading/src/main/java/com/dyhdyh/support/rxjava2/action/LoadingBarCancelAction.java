package com.dyhdyh.support.rxjava2.action;

import android.view.View;

import com.dyhdyh.widget.loading.bar.LoadingBar;

import io.reactivex.functions.Action;

/**
 * author  dengyuhan
 * created 2017/7/19 17:04
 */
public class LoadingBarCancelAction implements Action,LoadingCancelAction {
    protected View mParent;

    public LoadingBarCancelAction(View parent) {
        this.mParent = parent;
    }

    @Override
    public void cancel() {
        LoadingBar.cancel(mParent);
    }

    @Override
    public void run() throws Exception {
        cancel();
    }
}
