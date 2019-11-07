package ru.headsandhands.presentation.di.modules;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.headsandhands.data.LoginDataSource;
import ru.headsandhands.data.LoginRepository;
import ru.headsandhands.data.net.api.OpenWeatherAPI;
import ru.headsandhands.data.net.repository.OpenWeatherRepository;
import ru.headsandhands.domain.repository.ApiRepository;
import ru.headsandhands.presentation.BuildConfig;

/**
 * Created by yasina on 10/10/2019
 */

@Module
public class DataModule {

    @Inject
    Context mContext;

    @Provides
    @Singleton
    ApiRepository provideApiRepository(OpenWeatherRepository apiRepository) {
        return apiRepository;
    }

    @Provides
    @Singleton
    LoginRepository provideLoginRepository(){
        return new LoginRepository(new LoginDataSource());
    }

    @Provides
    @Singleton
    OpenWeatherAPI provideCashierAPI(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Response response = chain.proceed(request);
                        int tryCount = 0;
                        while (!response.isSuccessful() && tryCount < 3) {
                            Log.d("intercept", "Request is not successful - " + tryCount);
                            tryCount++;
                            response = chain.proceed(request);
                        }
                        return response;
                    }
                }).connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(OpenWeatherAPI.class);
    }

}
