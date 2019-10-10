package ru.headsandhands.domain.repository;

import io.reactivex.Observable;
import ru.headsandhands.domain.response_model.WeatherInCity;

/**
 * Created by yasina on 10/10/2019
 */
public interface ApiRepository {
    Observable<WeatherInCity> getWeather(String city);
}
