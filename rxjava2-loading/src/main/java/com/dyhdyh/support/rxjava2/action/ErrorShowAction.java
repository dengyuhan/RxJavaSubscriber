package com.dyhdyh.support.rxjava2.action;

/**
 * author  dengyuhan
 * created 2017/7/19 17:35
 */
public interface ErrorShowAction {

    void showError(CharSequence message, Throwable throwable);
}
