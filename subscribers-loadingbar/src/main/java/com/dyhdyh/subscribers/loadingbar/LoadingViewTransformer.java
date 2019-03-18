package com.dyhdyh.subscribers.loadingbar;

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
public class LoadingViewTransformer<T> extends LoadingObservableTransformer {
    private View mParent;
    private View mErrorParent;
    private CharSequence mDefaultMessage;
    private CharSequence mDefaultErrorMessage;

    public LoadingViewTransformer(View parent, View errorParent) {
        this(parent, errorParent, null, null);
    }

    public LoadingViewTransformer(View parent, View errorParent, CharSequence defaultMessage, CharSequence defaultErrorMessage) {
        this.mParent = parent;
        this.mErrorParent = errorParent;
        this.mDefaultMessage = defaultMessage;
        this.mDefaultErrorMessage = defaultErrorMessage;
    }

    @NonNull
    @Override
    protected Consumer<Disposable> getShowConsumer() {
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
    protected Consumer<Throwable> getErrorConsumer() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (!TextUtils.isEmpty(mDefaultErrorMessage)) {
                    LoadingBar.view(mErrorParent)
                            .setFactoryFromView(SimpleErrorLayout.create(mErrorParent.getContext(), mDefaultErrorMessage))
                            .show();
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
                LoadingBar.view(mParent).cancel();
            }
        };
    }
}
