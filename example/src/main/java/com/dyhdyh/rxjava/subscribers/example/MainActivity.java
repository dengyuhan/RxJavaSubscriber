package com.dyhdyh.rxjava.subscribers.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dyhdyh.subscriber.rxjava.RxJavaSchedulers;
import com.dyhdyh.subscribers.loadingbar.rxjava.SimpleLoadingBarSubscriber;
import com.dyhdyh.subscribers.loadingbar.rxjava.SimpleLoadingDialogSubscriber;

import java.util.Random;

import rx.Observable;
import rx.Subscriber;


public class MainActivity extends AppCompatActivity {
    View layoutContent;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutContent = findViewById(R.id.layout_content);
        tv_result = findViewById(R.id.tv_result);
    }


    public void clickLoadingBarSubscriber(View view) {
        createAsyncObservable()
                .subscribe(new SimpleLoadingBarSubscriber<String>(layoutContent, "加载失败") {
                    @Override
                    public void onNext(String s) {
                        super.onNext(s);
                        tv_result.setText(s);
                    }
                });
    }

    public void clickLoadingDialogSubscriber(View view) {
        createAsyncObservable()
                .subscribe(new SimpleLoadingDialogSubscriber<String>(this, "正在加载", "加载失败") {
                    @Override
                    public void onNext(String s) {
                        super.onNext(s);
                        tv_result.setText(s);
                    }
                });
    }


    public Observable<String> createAsyncObservable() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (new Random().nextBoolean()) {
                    subscriber.onNext("成功");
                } else {
                    subscriber.onError(new Exception("随机失败"));
                }
                subscriber.onCompleted();
            }
        }).compose(RxJavaSchedulers.<String>io2main());
    }
}
