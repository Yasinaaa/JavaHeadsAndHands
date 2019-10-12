package ru.headsandhands.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.content.Context;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import ru.headsandhands.domain.response_model.WeatherInCity;
import ru.headsandhands.domain.usecases.GetWeatherUseCase;
import ru.headsandhands.presentation.R;
import ru.headsandhands.data.LoginRepository;
import ru.headsandhands.domain.models.LoggedInUser;
import ru.headsandhands.domain.models.LoginFormState;
import ru.headsandhands.domain.models.Result;
import ru.headsandhands.domain.models.LoggedInUserView;
import ru.headsandhands.domain.models.LoginResult;
import ru.headsandhands.presentation.viewmodel.base.BaseViewModel;

public class LoginViewModel extends BaseViewModel {

    private final String PASSWORD_PATTERN = "^(?=.{6,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$";

    @Inject
    Context mContext;

    @Inject
    LoginRepository mLoginRepository;

    @Inject
    GetWeatherUseCase mGetWeatherUseCase;

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private MutableLiveData<String> mWeatherResult = new MutableLiveData<>();

    @Inject
    public LoginViewModel() {}

    public void login(String username, String password) {
        Result<LoggedInUser> result = mLoginRepository.login(username, password);

        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String email, String password) {
        Boolean isValidEmail = isValidEmail(email);
        Boolean isValidPassword = isPasswordValid(password);
        loginFormState.setValue(new LoginFormState(isValidEmail, isValidPassword));
//        if (!isValidEmail(email)) {
//            loginFormState.setValue(new LoginFormState(R.string.invalid_email, null));
//        } else if (!isPasswordValid(password)) {
//            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
//        } else {
//            loginFormState.setValue(new LoginFormState(true));
//        }
    }

    private boolean isValidEmail(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return username.trim().isEmpty();
        }
    }

    private boolean isPasswordValid(String password) {
        if (password != null) {
            Pattern r = Pattern.compile(PASSWORD_PATTERN);
            Matcher m = r.matcher(password);
            return m.find();
        }else {
            return false;
        }
    }

    public void getWeather(String city){
        mGetWeatherUseCase.setParams(city);
        mGetWeatherUseCase.execute(new WeatherSubscriber());
    }

    protected class WeatherSubscriber extends DisposableObserver<WeatherInCity> {

        public WeatherSubscriber() {
            super();
        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(WeatherInCity weatherInCity) {
            String weather = String.format("%s temp=%s pressure=%s humidity=%s", weatherInCity.name, weatherInCity.main.temp, weatherInCity.main.pressure, weatherInCity.main.humidity);
            mWeatherResult.setValue(weather);
        }
    }

    public LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    public LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public LiveData<String> getWeatherResult() {
        return mWeatherResult;
    }

}
