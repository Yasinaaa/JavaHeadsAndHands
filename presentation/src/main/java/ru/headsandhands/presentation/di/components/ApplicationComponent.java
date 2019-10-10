package ru.headsandhands.presentation.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;
import ru.headsandhands.data.net.api.OpenWeatherAPI;
import ru.headsandhands.presentation.di.modules.ActivityModule;
import ru.headsandhands.presentation.di.modules.ApplicationModule;

/**
 * Created by yasina on 10/10/2019
 */

@Singleton
@Component(modules = {ApplicationModule.class, ActivityModule.class})
public interface ApplicationComponent {

//    void inject(BaseActivity baseActivity);

//    PostExecutionThread postExecutionThread();

//    ThreadExecutor threadExecutor();
//
    OpenWeatherAPI api();

    Context provideContextApplication();
//
//    //lenta
//    LentaRepository getLentaRepository();
//
//    Retrofit.Builder provideApi();
//
//    MainThread providesMainThread();

}