package ru.headsandhands.domain.executors;

import io.reactivex.Scheduler;

/**
 * Created by yasina on 01/03/2019
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
