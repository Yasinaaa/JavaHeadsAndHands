package ru.headsandhands.presentation.presenter;


import ru.headsandhands.domain.usecases.base.ApiUseCase;

/**
 * Created by yasina on 11/10/2019
 */

public abstract class BasePresenter<TView> implements Presenter<TView> {

    protected ApiUseCase<TView> mUseCase;
    protected TView mView;

    public BasePresenter() {
    }

    public BasePresenter(ApiUseCase j) {
        mUseCase = j;
    }

    @Override
    public void destroy() {
        unsubscribe();
    }

    @Override
    public void pause() {
        unsubscribe();
    }

    @Override
    public void setView(TView view) {
        mView = view;
    }

    private void unsubscribe() {
        if (mUseCase != null)
            mUseCase.unsubscribe();
    }
}
