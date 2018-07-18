package com.dyhdyh.rxjava.subscribers.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dyhdyh.subscriber.rxjava2.RxJava2Schedulers;
import com.dyhdyh.subscribers.loadingbar.rxjava2.SimpleLoadingBarObserver;
import com.dyhdyh.subscribers.loadingbar.rxjava2.SimpleLoadingDialogObserver;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


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
                .subscribe(new SimpleLoadingBarObserver<String>(layoutContent, "加载失败") {
                    @Override
                    public void onNext(String s) {
                        super.onNext(s);
                        tv_result.setText(s);
                    }
                });
    }

    public void clickLoadingDialogSubscriber(View view) {
        createAsyncObservable()
                .subscribe(new SimpleLoadingDialogObserver<String>(this, "正在加载", "加载失败") {
                    @Override
                    public void onNext(String s) {
                        super.onNext(s);
                        tv_result.setText(s);
                    }
                });
    }


    public Observable<String> createAsyncObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (new Random().nextBoolean()) {
                    emitter.onNext("成功");
                } else {
                    emitter.onError(new Exception("随机失败"));
                }
                emitter.onComplete();
            }
        }).compose(RxJava2Schedulers.<String>io2main());
    }
}
