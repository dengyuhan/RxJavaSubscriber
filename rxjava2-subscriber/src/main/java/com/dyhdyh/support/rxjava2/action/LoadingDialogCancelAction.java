package com.dyhdyh.support.rxjava2.action;

import com.dyhdyh.widget.loading.dialog.LoadingDialog;

import io.reactivex.functions.Action;

/**
 * 取消LoadingDialog
 * author  dengyuhan
 * created 2017/7/18 17:19
 */
public class LoadingDialogCancelAction implements Action, LoadingCancelAction {

    @Override
    public void run() throws Exception {
        cancel();
    }

    @Override
    public void cancel() {
        LoadingDialog.cancel();
    }
}
