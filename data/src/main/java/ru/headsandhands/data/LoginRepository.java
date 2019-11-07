package ru.headsandhands.data;

import javax.inject.Inject;

import ru.headsandhands.domain.models.LoggedInUser;
import ru.headsandhands.domain.models.Result;

/**
 * Created by yasina on 10/10/2019
 */
public class LoginRepository {

    @Inject
    LoginDataSource dataSource;

    private LoggedInUser user = null;

    @Inject
    public LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
    }

    public Result<LoggedInUser> login(String username, String password) {
        Result<LoggedInUser> result = dataSource.login(username, password);
        if (result instanceof Result.Success) {
            setLoggedInUser(((Result.Success<LoggedInUser>) result).getData());
        }
        return result;
    }
}

