package com.dyhdyh.subscribers.loadingbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.dyhdyh.widget.loadingbar2.LoadingBar;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author dengyuhan
 * created 2019/3/18 14:39
 */
public class LoadingDialogTransformer<T> extends LoadingObservableTransformer {
    private Context mContext;
    private CharSequence mDefaultMessage;
    private CharSequence mDefaultErrorMessage;

    public LoadingDialogTransformer(Context context) {
        this(context, null, null);
    }

    public LoadingDialogTransformer(Context context, CharSequence defaultMessage, CharSequence defaultErrorMessage) {
        this.mContext = context;
        this.mDefaultMessage = defaultMessage;
        this.mDefaultErrorMessage = defaultErrorMessage;
    }

    @NonNull
    @Override
    protected Consumer<Disposable> getShowConsumer() {
        return new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                Log.d("------>", "show--->"+Thread.currentThread().getName());
                LoadingBar.dialog(mContext)
                        .extras(TextUtils.isEmpty(mDefaultMessage) ? null : new Object[]{mDefaultMessage})
                        .show();
            }
        };
    }

    @NonNull
    @Override
    protected Consumer<Throwable> getErrorConsumer() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.d("------>", "error--->"+Thread.currentThread().getName());
                if (!TextUtils.isEmpty(mDefaultErrorMessage)) {
                    Toast.makeText(mContext, mDefaultErrorMessage, Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @NonNull
    @Override
    protected Action getCancelAction() {
        return new Action() {
            @Override
            public void run() throws Exception {
                Log.d("------>", "cancel--->"+Thread.currentThread().getName());
                LoadingBar.dialog(mContext).cancel();
            }
        };
    }
}
