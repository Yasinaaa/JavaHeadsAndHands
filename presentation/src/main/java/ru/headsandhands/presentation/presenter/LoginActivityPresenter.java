package ru.headsandhands.presentation.presenter;

import android.content.Context;

import javax.inject.Inject;

import ru.headsandhands.domain.usecases.LoginUseCase;
import ru.headsandhands.presentation.di.PerActivity;
import ru.headsandhands.presentation.view.LoginActivityView;

/**
 * Created by yasina on 11/10/2019
 */

@PerActivity
public class LoginActivityPresenter extends BasePresenter<LoginActivityView> {

    @Inject
    Context mContext;

    @Inject
    LoginUseCase mLoginUseCase;

    @Inject
    LoginActivityPresenter() {
        super();
    }
}
