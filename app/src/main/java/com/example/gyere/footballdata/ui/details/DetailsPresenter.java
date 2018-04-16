package com.example.gyere.footballdata.ui.details;

import com.example.gyere.footballdata.ui.Presenter;

public class DetailsPresenter extends Presenter<DetailsScreen> {

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showTeams() {
        screen.showDetails();
    }
}
