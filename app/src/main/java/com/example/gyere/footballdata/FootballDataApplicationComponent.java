package com.example.gyere.footballdata;

import com.example.gyere.footballdata.network.NetworkModule;
import com.example.gyere.footballdata.ui.UIModule;
import com.example.gyere.footballdata.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface FootballDataApplicationComponent {
    void inject(MainActivity mainActivity);
}
