package com.dyhdyh.subscribers.loadingbar;

import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.View;

import com.dyhdyh.subscribers.loadingbar.view.SimpleErrorLayout;
import com.dyhdyh.widget.loadingbar2.LoadingBar;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author dengyuhan
 * created 2019/3/18 14:39
 */
public class LoadingViewTransformer<T> extends LoadingTransformer<T> {
    protected View mParent;
    protected CharSequence mDefaultMessage;
    protected CharSequence mDefaultErrorMessage;

    public LoadingViewTransformer(View parent) {
        this(parent, null, null);
    }

    public LoadingViewTransformer(View parent, @StringRes int defaultMessageRes, @StringRes int defaultErrorMessageRes) {
        this(parent, parent.getResources().getText(defaultMessageRes), parent.getResources().getText(defaultErrorMessageRes));
    }

    public LoadingViewTransformer(View parent, CharSequence defaultMessage, CharSequence defaultErrorMessage) {
        this.mParent = parent;
        this.mDefaultMessage = defaultMessage;
        this.mDefaultErrorMessage = defaultErrorMessage;
    }

    @NonNull
    @Override
    protected Consumer<Disposable> showLoadingConsumer() {
        return new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                LoadingBar.view(mParent)
                        .extras(TextUtils.isEmpty(mDefaultMessage) ? null : new Object[]{mDefaultMessage})
                        .show();
            }
        };
    }

    @NonNull
    @Override
    protected Consumer<Throwable> showErrorConsumer() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (!TextUtils.isEmpty(mDefaultErrorMessage)) {
                    LoadingBar.view(mParent)
                            .setFactoryFromView(SimpleErrorLayout.create(mParent.getContext(), mDefaultErrorMessage))
                            .show();
                }
            }
        };
    }

    @NonNull
    @Override
    protected Action cancelLoadingAction() {
        return new Action() {
            @Override
            public void run() throws Exception {
                LoadingBar.view(mParent).cancel();
            }
        };
    }
}
