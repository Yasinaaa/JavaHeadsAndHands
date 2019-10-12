package ru.headsandhands.domain.models;

/**
 * Created by yasina on 10/10/2019
 */
public class LoggedInUserView {

    private String displayName;

    public LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
