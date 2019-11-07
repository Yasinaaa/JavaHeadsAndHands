package ru.headsandhands.presentation.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import butterknife.BindView;
import ru.headsandhands.presentation.AndroidApplication;
import ru.headsandhands.presentation.R;
import ru.headsandhands.presentation.di.components.ApplicationComponent;
import ru.headsandhands.presentation.view.BaseView;

/**
 * Created by yasina on 11/10/2019
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Nullable
    @BindView(R.id.pb)
    protected ProgressBar pb;

    @Override
    public void stopProgressDialog() {
        if (pb != null)
            pb.setVisibility(View.GONE);
    }

    @Override
    public void startProgressDialog() {
        if (pb != null)
            pb.setVisibility(View.VISIBLE);
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}