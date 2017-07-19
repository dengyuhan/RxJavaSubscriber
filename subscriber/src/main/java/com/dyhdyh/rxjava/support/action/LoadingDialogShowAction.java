package com.dyhdyh.rxjava.support.action;

import android.content.Context;
import android.text.TextUtils;

import com.dyhdyh.widget.loading.dialog.LoadingDialog;

/**
 * author  dengyuhan
 * created 2017/7/19 17:04
 */
public class LoadingDialogShowAction implements ILoadingShow {
    protected Context mContext;

    public LoadingDialogShowAction(Context context) {
        this.mContext = context;
    }

    @Override
    public void show(CharSequence message) {
        if (TextUtils.isEmpty(message)){
            LoadingDialog.make(mContext).show();
        }else{
            LoadingDialog.make(mContext).setMessage(message).show();
        }
    }
}
