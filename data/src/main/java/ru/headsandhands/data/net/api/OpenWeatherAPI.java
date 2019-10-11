package ru.headsandhands.data.net.api;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.headsandhands.domain.response_model.WeatherInCity;

/**
 * Created by yasina on 10/10/2019
 */

public interface OpenWeatherAPI {

    @POST("/weather")
    Observable<WeatherInCity> login(@Path("q") String city);
}
