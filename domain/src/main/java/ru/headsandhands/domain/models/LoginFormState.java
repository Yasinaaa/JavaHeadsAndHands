package ru.headsandhands.domain.models;

/**
 * Data validation state of the login form.
 */
public class LoginFormState {

    private boolean emailValid;
    private boolean passwordValid;

    public LoginFormState(boolean isValidEmail, boolean isValidPassword) {
        this.emailValid = isValidEmail;
        this.passwordValid = isValidPassword;
    }

    public boolean isEmailValid() {
        return emailValid;
    }

    public void setEmailValid(Boolean emailValid) {
        this.emailValid = emailValid;
    }

    public boolean isPasswordValid() {
        return passwordValid;
    }

    public void setPasswordValid(boolean passwordValid) {
        this.passwordValid = passwordValid;
    }
}
