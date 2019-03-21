package com.dyhdyh.rxjava.subscribers.example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dyhdyh.subscribers.loadingbar.LoadingDialogTransformer;
import com.dyhdyh.subscribers.loadingbar.LoadingViewTransformer;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    View layoutContent;
    View errorContainer;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutContent = findViewById(R.id.layout_content);
        errorContainer = findViewById(R.id.layout_error);
        tv_result = findViewById(R.id.tv_result);
    }


    public void clickLoadingBarSubscriber(View view) {
        createAsyncObservable(false)
                .compose(new LoadingViewTransformer(layoutContent))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext(), onError());
    }


    public void clickLoadingViewError(View view) {
        createAsyncObservable(true)
                .compose(new CustomViewTransformer(layoutContent, "默认提示", "默认错误提示", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickLoadingViewError(v);
                    }
                }))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext(), onError());
    }

    public void clickLoadingDialogSubscriber(View view) {
        createAsyncObservable(false)
                .compose(new LoadingDialogTransformer(this))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext(), onError());
    }

    public void clickLoadingDialogError(View view) {
        createAsyncObservable(true)
                .compose(new LoadingDialogTransformer(this, "默认提示", "默认错误提示"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext(), onError());
    }


    private Observable<String> createAsyncObservable(final boolean error) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    Thread.sleep(2000);
                    if (error) {
                        String s = null;
                        s.length();
                    } else {
                        emitter.onNext("成功");
                    }
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io());
    }


    @NonNull
    private Consumer<String> onNext() {
        return new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                tv_result.setText(s);
                Log.d("------>", "onNext--->" + Thread.currentThread().getName());
            }
        };
    }

    @NonNull
    private Consumer<Throwable> onError() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.d("------>", "onError--->" + Thread.currentThread().getName());
            }
        };
    }

}
