package ru.headsandhands.domain.models;

import androidx.annotation.Nullable;

/**
 * Data validation state of the login form.
 */
public class WeatherGetState {

    @Nullable
    private String error;
    private boolean isDataValid;

    public WeatherGetState(@Nullable String error) {
        this.error = error;
        this.isDataValid = false;
    }

    public WeatherGetState(boolean isDataValid) {
        this.error = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    public String getUsernameError() {
        return error;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
