package ru.headsandhands.domain.usecases;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.headsandhands.domain.executors.PostExecutionThread;
import ru.headsandhands.domain.executors.ThreadExecutor;
import ru.headsandhands.domain.repository.ApiRepository;
import ru.headsandhands.domain.response_model.WeatherInCity;
import ru.headsandhands.domain.usecases.base.ApiUseCase;

/**
 * Created by yasina on 10/10/2019
 **/

public class GetWeatherUseCase extends ApiUseCase<WeatherInCity> {

    private final String APID = "b6907d289e10d714a6e88b30761fae22";
    private ApiRepository mRepository;
    private String mCity;

    @Inject
    protected GetWeatherUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ApiRepository cashierRepository) {
        super(threadExecutor, postExecutionThread);
        this.mRepository = cashierRepository;
    }

    public void setParams(String city) {
        this.mCity = city;
    }

    @Override
    protected Observable<WeatherInCity> buildUseCaseObservable() {
        return mRepository.getWeather(mCity, APID);
    }

}
