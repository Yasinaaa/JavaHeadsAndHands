package ru.headsandhands.presentation.di.modules;

import android.content.Context;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

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
import ru.headsandhands.data.net.api.OpenWeatherAPI;
import ru.headsandhands.data.net.repository.OpenWeatherRepository;
import ru.headsandhands.domain.repository.ApiRepository;
import ru.headsandhands.presentation.BuildConfig;

/**
 * Created by yasina on 10/10/2019
 */

@Module
public class ActivityModule {

}
