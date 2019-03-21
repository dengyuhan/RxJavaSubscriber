package com.dyhdyh.rxjava.subscribers.example;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author dengyuhan
 * created 2019/3/20 20:29
 */
public class ExampleErrorLayout extends RelativeLayout {
    private TextView mMessageView;
    private View mRetryView;

    public ExampleErrorLayout(Context context) {
        this(context, null);
    }

    public ExampleErrorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExampleErrorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(getContext(), R.layout.view_custom_error, this);
        mMessageView = findViewById(R.id.tv_label_error);
        mRetryView = findViewById(R.id.btn_error);
    }


    public void setMessageText(CharSequence text) {
        mMessageView.setText(text);
    }

    public void setOnRetryClickListener(OnClickListener l) {
        mRetryView.setOnClickListener(l);
    }
}
