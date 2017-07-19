package com.dyhdyh.rxjava.support.delegate.impl;

import android.view.View;

import com.dyhdyh.rxjava.support.delegate.LoadingDelegate;
import com.dyhdyh.widget.loading.bar.LoadingBar;

/**
 * LoadingBar样式
 * author  dengyuhan
 * created 2017/7/18 17:43
 */
public class LoadingBarDelegateImpl implements LoadingDelegate{
    protected View mParent;

    public LoadingBarDelegateImpl(View parent) {
        this.mParent = parent;
    }

    @Override
    public void show(CharSequence message) {
        LoadingBar.make(mParent).show();
    }

    @Override
    public void cancel() {
        LoadingBar.cancel(mParent);
    }
}
