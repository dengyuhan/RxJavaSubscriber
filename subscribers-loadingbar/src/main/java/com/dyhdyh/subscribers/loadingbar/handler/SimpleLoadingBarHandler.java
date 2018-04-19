package com.dyhdyh.subscribers.loadingbar.handler;

import android.view.View;

import com.dyhdyh.subscriber.handler.LoadingHandler;
import com.dyhdyh.widget.loading.bar.LoadingBar;

/**
 * view样式的loading
 * @author dengyuhan
 *         created 2018/4/19 15:22
 */
public class SimpleLoadingBarHandler implements LoadingHandler<String> {
    protected View mParent;

    public SimpleLoadingBarHandler(View parent) {
        this.mParent = parent;
    }


    @Override
    public void show(String params) {
        LoadingBar.make(mParent).show();
    }

    @Override
    public void cancel() {
        LoadingBar.cancel(mParent);
    }

}
