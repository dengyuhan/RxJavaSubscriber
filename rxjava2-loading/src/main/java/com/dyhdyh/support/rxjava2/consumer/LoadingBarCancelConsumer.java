package com.dyhdyh.support.rxjava2.consumer;

import android.util.Log;
import android.view.View;

import com.dyhdyh.support.rxjava2.action.LoadingCancelAction;
import com.dyhdyh.support.rxjava2.action.LoadingBarCancelAction;

import io.reactivex.functions.Action;

/**
 * 取消LoadingBar
 * author  dengyuhan
 * created 2017/7/18 17:19
 */
public class LoadingBarCancelConsumer implements Action {
    private LoadingCancelAction mAction;

    public LoadingBarCancelConsumer(View parent) {
        this.mAction = new LoadingBarCancelAction(parent);
    }


    @Override
    public void run() throws Exception {
        Log.d(Thread.currentThread().getName() + "-------------->", "doOnComplete----->");
        mAction.cancel();
    }
}
