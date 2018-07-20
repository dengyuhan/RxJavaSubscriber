## 快速开始
### 相关项目
[LoadingBar](https://github.com/dengyuhan/LoadingBar)  
[RecyclerViewHelper](https://github.com/dengyuhan/RecyclerViewHelper)

### Gradle
```
//RxJava2
implementation 'io.reactivex.rxjava2:rxjava:x.x.x'
implementation 'io.reactivex.rxjava2:rxandroid:x.x.x'

//必选
implementation 'com.dyhdyh.rxjava:subscribers:1.0.0-beta7'

//如果需要LoadingBar的支持(可选)
implementation 'com.dyhdyh.rxjava:subscribers-loadingbar:1.0.0-beta7'
implementation 'com.dyhdyh.loadingbar:loadingbar:1.4.7'

//如果需要分页的支持(可选)
implementation 'com.dyhdyh:recyclerview-helper:1.0.0-beta7'
```
### RxJava2Observable
```
//快速创建一个异步任务
RxJava2Observable.async(new Function<Void, String>() {
    @Override
    public String apply(Void aVoid) throws Exception {
        //该代码块会执行在io线程
        return "result";
    }
});
```

### 预设Observer
##### SimpleLoadingBarObserver
```
//会自动以View的形式加上loading,并在next和error中取消
//参数1是 loadingView的容器
//参数2是 失败时默认的错误提示
.subscribe(new SimpleLoadingBarObserver<String>(loadingParent,"加载失败"){
    @Override
    public void onNext(String s) {
        super.onNext(s);
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
});
```
##### SimpleLoadingDialogObserver
```
//会自动以Dialog的形式加上loading,并在next和error中取消
//参数1是 context
//参数2是 失败时默认的错误提示
.subscribe(new SimpleLoadingDialogObserver<String>(context,"加载失败"){
    @Override
    public void onNext(String s) {
        super.onNext(s);
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
});
```

##### SimplePagingObserver
泛型1是从onNext获取到的对象类型,泛型2是集合的元素类型  
继承SimplePagingObserver

```
.subscribe(new SimplePagingObserver<List<String>, String>(loadingParent, mPagingViewController, "出错了") {
    @Override
    protected void onRefreshResponse(List<String> response, List<String> list) {
        //刷新成功后回调
        rv.setLayoutManager(new LinearLayoutManager(LoadMoreActivity.this));
        mAdapter = new SimpleAdapter(response);
        rv.setAdapter(mAdapter);
    }

    @Override
    protected void onAppendResponse(List<String> response, List<String> list) {
        //加载更多成功后回调
        mAdapter.addAll(response);
    }

    @Override
    protected boolean isLast(List<String> response) {
        //最后一页时返回true
        //这里举例假设第三页是最后一页
        return rv.getPage() == 3;
    }

});

```

### 自定义Observer
如果Loading和Error只需要传递String，继承`CharSequenceObserver`，否则继承`BaseObserver `  
继承`BaseObserver`要注意三个泛型，`数据源`、`Loading参数`、`Error参数 ` 

```
public class CustomObserver extends BaseObserver<Data,CharSequence,CharSequence> {

}
```

不管继承谁，都要重写`createLoadingHandler()`和`createErrorHandler()`，这两个handler用于处理Loading和Error的UI，return自定义的handler

```
@Override
public LoadingHandler createLoadingHandler() {
    //自定义loading的UI处理
    return new CustomLoadingHandler();
}

@Override
public ErrorHandler createErrorHandler() {
    //自定义error的UI处理
    return new CustomErrorHandler();
}
```

### 进阶自定义Observer
如果需要自己构造参数，重写`buildLoadingParams`和`buildErrorParams`，这两个参数会传到Handler中，这里用CharSequence做例子  

```
@Override
protected CharSequence buildLoadingParams() {
    return "正在加载";
}

@Override
protected CharSequence buildErrorParams(Throwable e) {
    return "加载失败";
}
```
要自定义UI显示与隐藏的逻辑，重写下面三个方法

```
@Override
public void showLoading(CharSequence params, LoadingHandler<CharSequence> handler) {
    super.showLoading(params, handler);
}

@Override
public void cancelLoading(LoadingHandler<CharSequence> handler) {
    super.cancelLoading(handler);
}

@Override
public void showError(CharSequence errorParams, Throwable e, ErrorHandler<CharSequence> handler) {
    super.showError(errorParams, e, handler);
}
```
