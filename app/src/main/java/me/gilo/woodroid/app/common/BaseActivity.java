package me.gilo.woodroid.app.common;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import dagger.android.support.DaggerAppCompatActivity;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

import javax.inject.Inject;


/**
 * This Activity is to be inherited by any activity to initiate the injection.
 */

@SuppressLint("Registered")
public class BaseActivity extends DaggerAppCompatActivity {

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    public <T extends ViewModel> T getViewModel(final Class<T> cls) {
        return ViewModelProviders.of(this, viewModelFactory).get(cls);
    }


    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
