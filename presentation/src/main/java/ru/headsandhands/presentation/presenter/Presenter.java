package ru.headsandhands.presentation.presenter;

/**
 * Created by yasina on 11/10/2019
 */

public interface Presenter<TView> {

    void destroy();

    void pause();

    void setView(TView view);
}
