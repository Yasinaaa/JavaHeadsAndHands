package ru.headsandhands.presentation.ui;

import javax.inject.Inject;

import ru.headsandhands.presentation.presenter.Presenter;

/**
 * Created by yasina on 11/10/2019
 */

public abstract class BasePresenterActivity<TInjector, TPresenter extends Presenter> extends BaseInjectorActivity<TInjector> {

    @Inject
    protected TPresenter mPresenter;

    @Override
    protected void initialize() {
        super.initialize();
        mPresenter.setView(this);
    }
}