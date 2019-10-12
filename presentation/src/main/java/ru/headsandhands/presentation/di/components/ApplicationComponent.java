package ru.headsandhands.presentation.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ru.headsandhands.data.LoginRepository;
import ru.headsandhands.data.net.api.OpenWeatherAPI;
import ru.headsandhands.domain.executors.PostExecutionThread;
import ru.headsandhands.domain.executors.ThreadExecutor;
import ru.headsandhands.domain.repository.ApiRepository;
import ru.headsandhands.presentation.di.modules.DataModule;
import ru.headsandhands.presentation.di.modules.ApplicationModule;
import ru.headsandhands.presentation.ui.BaseActivity;

/**
 * Created by yasina on 10/10/2019
 */

@Singleton
@Component(modules = {ApplicationModule.class, DataModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);
    PostExecutionThread postExecutionThread();
    ThreadExecutor threadExecutor();
    OpenWeatherAPI api();
    Context provideContextApplication();
    ApiRepository getApiRepository();
    LoginRepository provideLoginRepository();
}