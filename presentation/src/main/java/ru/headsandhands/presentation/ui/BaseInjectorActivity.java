package ru.headsandhands.presentation.ui;

import android.os.Bundle;

import androidx.annotation.CallSuper;

/**
 * Created by yasina on 11/10/2019
 */

public abstract class BaseInjectorActivity<TInjector> extends BaseActivity{

    protected TInjector mInjectorComponent;

    public TInjector getComponent() {
        return mInjectorComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInjectorComponent = initializeComponent();
        initialize();
    }

    @CallSuper
    protected void initialize() {
        initializeInjections();
    }

    protected abstract TInjector initializeComponent();

    protected abstract void initializeInjections();


}
