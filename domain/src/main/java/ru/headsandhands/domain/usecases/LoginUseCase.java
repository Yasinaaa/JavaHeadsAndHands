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

public class LoginUseCase extends ApiUseCase<WeatherInCity> {

    private ApiRepository mRepository;
    private String mCity;

    @Inject
    protected LoginUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ApiRepository cashierRepository) {
        super(threadExecutor, postExecutionThread);
        this.mRepository = cashierRepository;
    }

    public void setParams(String city) {
        this.mCity = city;
    }

    @Override
    protected Observable<WeatherInCity> buildUseCaseObservable() {
        return mRepository.getWeather(mCity);
    }

}
