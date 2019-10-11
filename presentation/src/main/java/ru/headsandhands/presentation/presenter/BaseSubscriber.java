package ru.headsandhands.presentation.presenter;

import io.reactivex.observers.DisposableObserver;
import ru.headsandhands.presentation.view.BaseView;

public class BaseSubscriber<T> extends DisposableObserver<T> {

    private BaseView mView;

    public BaseSubscriber(BaseView view) {
        this.mView = view;
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable e) {
        mView.stopProgressDialog();
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {
    }
}
