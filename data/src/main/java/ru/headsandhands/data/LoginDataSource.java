package ru.headsandhands.data;

import java.io.IOException;
import ru.headsandhands.domain.models.LoggedInUser;
import ru.headsandhands.domain.models.Result;

/**
 * Created by yasina on 10/10/2019
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String email, String password) {

        try {
            // TODO: saving process
            LoggedInUser fakeUser = new LoggedInUser(java.util.UUID.randomUUID().toString(), email);
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

}
