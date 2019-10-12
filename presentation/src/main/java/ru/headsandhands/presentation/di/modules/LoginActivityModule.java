package ru.headsandhands.presentation.di.modules;

import androidx.lifecycle.ViewModelProviders;

import javax.inject.Singleton;

import dagger.Module;
import ru.headsandhands.presentation.ui.LoginActivity;
import ru.headsandhands.presentation.viewmodel.LoginViewModel;
import ru.headsandhands.presentation.viewmodel.base.ViewModelFactory;

/**
 * Created by yasina on 10/10/2019
 */

@Module
public class LoginActivityModule {

    private LoginActivity mLoginActivity;

    public LoginActivityModule(LoginActivity activity){
        mLoginActivity = activity;
    }

    @Singleton
    LoginViewModel provideLoginViewModel(){
        return ViewModelProviders.of(mLoginActivity, new ViewModelFactory()).get(LoginViewModel.class);
    }

}
