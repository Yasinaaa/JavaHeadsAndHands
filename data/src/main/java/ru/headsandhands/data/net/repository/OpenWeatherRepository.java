package ru.headsandhands.data.net.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import ru.headsandhands.data.net.api.OpenWeatherAPI;
import ru.headsandhands.domain.repository.ApiRepository;
import ru.headsandhands.domain.response_model.WeatherInCity;

/**
 * Created by yasina on 10/10/2019
 */

@Singleton
public class OpenWeatherRepository implements ApiRepository {

    private OpenWeatherAPI mAPI;

    @Inject
    public OpenWeatherRepository(OpenWeatherAPI api) {
        this.mAPI = api;
    }

    @Override
    public Observable<WeatherInCity> getWeather(String city) {
        return mAPI.login(city);
    }
}
