package com.dyhdyh.rxjava.support.consumer;

import android.util.Log;
import android.view.View;

import com.dyhdyh.rxjava.support.action.ILoadingCancel;
import com.dyhdyh.rxjava.support.action.LoadingBarCancelAction;

import io.reactivex.functions.Action;

/**
 * 取消LoadingBar
 * author  dengyuhan
 * created 2017/7/18 17:19
 */
public class LoadingBarCancelConsumer implements Action {
    private ILoadingCancel mAction;

    public LoadingBarCancelConsumer(View parent) {
        this.mAction = new LoadingBarCancelAction(parent);
    }


    @Override
    public void run() throws Exception {
        Log.d(Thread.currentThread().getName() + "-------------->", "doOnComplete----->");
        mAction.cancel();
    }
}
