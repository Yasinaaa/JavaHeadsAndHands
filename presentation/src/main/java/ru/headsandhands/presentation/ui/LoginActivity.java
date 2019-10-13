package ru.headsandhands.presentation.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.headsandhands.domain.models.LoginResult;
import ru.headsandhands.presentation.R;
import ru.headsandhands.presentation.di.components.DaggerMainComponent;
import ru.headsandhands.presentation.di.components.MainComponent;
import ru.headsandhands.presentation.viewmodel.LoginViewModel;

/**
 * Created by yasina on 11/10/2019
 */

public class LoginActivity extends BaseInjectorActivity<MainComponent> {

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_sign_in)
    Button btnSignIn;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.til_email)
    TextInputLayout tilEmail;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;
    @BindView(R.id.container)
    ConstraintLayout container;

    @Inject
    LoginViewModel mLoginViewModel;

    @Override
    protected MainComponent initializeComponent() {
        return DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build();
    }

    @Override
    protected void initializeInjections() {
        getComponent().inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_login);

        mLoginViewModel.getLoginFormState().observe(this, loginFormState -> {
            if (loginFormState == null) {
                return;
            }
            btnSignIn.setEnabled(loginFormState.isPasswordValid());
            if (!loginFormState.isEmailValid()) {
                tilEmail.setError(getString(R.string.invalid_email));
            }else {
                tilEmail.setErrorEnabled(false);
            }
            if (!loginFormState.isPasswordValid()) {
                tilPassword.setError(getString(R.string.invalid_password));
            }else {
                tilPassword.setErrorEnabled(false);
            }
        });

        mLoginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    hideKeyboard();
                    mLoginViewModel.getWeather("London");
                }
            }
        });

        mLoginViewModel.getWeatherResult().observe(this, result -> {
            Snackbar.make(findViewById(android.R.id.content), result, Snackbar.LENGTH_LONG).show();
            stopProgressDialog();
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mLoginViewModel.loginDataChanged(etEmail.getText().toString(), etPassword.getText().toString());
            }
        };
        etEmail.addTextChangedListener(afterTextChangedListener);
        etPassword.addTextChangedListener(afterTextChangedListener);
        etPassword.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                onSignInClick();
            }
            return false;
        });
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
    }

    @OnClick(R.id.btn_sign_in)
    public void onSignInClick() {
        startProgressDialog();
        mLoginViewModel.login(etEmail.getText().toString(), etPassword.getText().toString());
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_create:
                //todo
                break;
        }
        return true;
    }
}
