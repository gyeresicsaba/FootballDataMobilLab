package com.example.gyere.footballdata;

import android.app.Application;

import com.example.gyere.footballdata.ui.UIModule;

public class FootballDataApplication extends Application {
    public static FootballDataApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerFootballDataApplicationComponent.builder()
                .uIModule(new UIModule(this)).build();
    }
}
