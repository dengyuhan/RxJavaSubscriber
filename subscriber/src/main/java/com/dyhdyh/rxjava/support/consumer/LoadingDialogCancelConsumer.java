package com.dyhdyh.rxjava.support.consumer;

import com.dyhdyh.rxjava.support.action.ILoadingCancel;
import com.dyhdyh.rxjava.support.action.LoadingDialogCancelAction;

import io.reactivex.functions.Action;

/**
 * 取消LoadingDialog
 * author  dengyuhan
 * created 2017/7/18 17:19
 */
public class LoadingDialogCancelConsumer implements Action{
    private ILoadingCancel mAction;

    public LoadingDialogCancelConsumer() {
        this.mAction = new LoadingDialogCancelAction();
    }

    @Override
    public void run() throws Exception {
        this.mAction.cancel();
    }
}
