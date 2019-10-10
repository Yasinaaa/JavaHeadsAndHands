package ru.headsandhands.presentation.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by yasina on 10/10/2019
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
