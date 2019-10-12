package ru.headsandhands.presentation.di.components;

import dagger.Component;
import ru.headsandhands.presentation.di.PerActivity;
import ru.headsandhands.presentation.di.modules.LoginActivityModule;
import ru.headsandhands.presentation.ui.LoginActivity;

/**
 * Created by yasina on 01/03/2019
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {LoginActivityModule.class})
public interface MainComponent extends ApplicationComponent {
    void inject(LoginActivity loginActivity);

}