package com.dyhdyh.rxjava.support.action;

import com.dyhdyh.widget.loading.dialog.LoadingDialog;

/**
 * author  dengyuhan
 * created 2017/7/19 17:04
 */
public class LoadingDialogCancelAction implements ILoadingCancel {

    @Override
    public void cancel() {
        LoadingDialog.cancel();
    }
}
