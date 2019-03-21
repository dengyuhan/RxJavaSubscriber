package com.dyhdyh.subscribers.loadingbar.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dyhdyh.subscribers.loadingbar.R;


/**
 * 简单的错误布局
 * author  dengyuhan
 * created 2017/7/20 14:47
 */
public class SimpleErrorLayout extends RelativeLayout{
    private TextView mMessageView;

    public SimpleErrorLayout(Context context) {
        this(context, null);
    }

    public SimpleErrorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleErrorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setBackgroundColor(Color.WHITE);
        View.inflate(getContext(), R.layout.loadingbar_layout_simple_error, this);
        mMessageView = (TextView) findViewById(R.id.tv_error_message);
    }

    public void setMessageText(CharSequence message) {
        this.mMessageView.setVisibility(VISIBLE);
        this.mMessageView.setText(message);
    }

    public TextView getMessageView() {
        return mMessageView;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    public static SimpleErrorLayout create(Context context, CharSequence message) {
        SimpleErrorLayout layout = new SimpleErrorLayout(context);
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        layout.setMessageText(message);
        return layout;
    }
}
