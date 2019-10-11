package ru.headsandhands.presentation.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.headsandhands.data.executor.JobExecutor;
import ru.headsandhands.domain.executors.PostExecutionThread;
import ru.headsandhands.domain.executors.ThreadExecutor;
import ru.headsandhands.presentation.AndroidApplication;
import ru.headsandhands.presentation.di.UIThread;

/**
 * Created by yasina on 01/03/2019
 */

@Module
public class ApplicationModule {

    private final AndroidApplication mApplication;

    public ApplicationModule(AndroidApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.mApplication;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

}
