package com.example.gyere.footballdata;

import android.app.Application;

import com.example.gyere.footballdata.ui.UIModule;

public class FootballDataApplication extends Application {
    public static FootballDataApplication injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerFootballDataApplication.builder()
                .uIModule(new UIModule(this)).build();
    }

}
