package ru.headsandhands.presentation;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;
import javax.inject.Inject;
import retrofit2.Retrofit;
import ru.headsandhands.presentation.di.components.ApplicationComponent;
import ru.headsandhands.presentation.di.components.DaggerApplicationComponent;
import ru.headsandhands.presentation.di.modules.ApplicationModule;

/**
 * Created by yasina on 10/10/2019
 */

public class AndroidApplication extends Application{

    private ApplicationComponent applicationComponent;

    @Inject
    Retrofit mRet;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
