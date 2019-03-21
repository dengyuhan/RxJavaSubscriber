package com.dyhdyh.rxjava.subscribers.example;

import android.text.TextUtils;
import android.view.View;

import com.dyhdyh.subscribers.loadingbar.LoadingViewTransformer;
import com.dyhdyh.widget.loadingbar2.LoadingBar;

import io.reactivex.functions.Consumer;

/**
 * @author dengyuhan
 * created 2019/3/21 10:47
 */
public class CustomViewTransformer<T> extends LoadingViewTransformer<T> {
    private View.OnClickListener mOnClickListener;

    public CustomViewTransformer(View parent, View.OnClickListener l) {
        super(parent);
        this.mOnClickListener = l;
    }

    public CustomViewTransformer(View parent, int defaultMessageRes, int defaultErrorMessageRes, View.OnClickListener l) {
        super(parent, defaultMessageRes, defaultErrorMessageRes);
        this.mOnClickListener = l;
    }

    public CustomViewTransformer(View parent, CharSequence defaultMessage, CharSequence defaultErrorMessage, View.OnClickListener l) {
        super(parent, defaultMessage, defaultErrorMessage);
        this.mOnClickListener = l;
    }

    @Override
    protected Consumer<Throwable> showErrorConsumer() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (TextUtils.isEmpty(mDefaultErrorMessage)) {
                    return;
                }
                final ExampleErrorLayout layout = new ExampleErrorLayout(mParent.getContext());
                layout.setOnRetryClickListener(mOnClickListener);
                layout.setMessageText(mDefaultErrorMessage);
                LoadingBar.view(mParent)
                        .setFactoryFromView(layout)
                        .show();
            }
        };
    }
}
