package com.example.gyere.footballdata.ui.main;

import com.example.gyere.footballdata.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showTeams() {
        screen.showTeams();
    }
}
