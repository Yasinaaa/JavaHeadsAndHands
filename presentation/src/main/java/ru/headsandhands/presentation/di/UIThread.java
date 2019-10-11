package ru.headsandhands.presentation.di;

import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.headsandhands.domain.executors.PostExecutionThread;


/**
 * Created by yasina on 11/10/2019
 */

@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }

}
