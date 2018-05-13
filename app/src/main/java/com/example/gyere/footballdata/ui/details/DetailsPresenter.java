package com.example.gyere.footballdata.ui.details;

import com.example.gyere.footballdata.FootballDataApplication;
import com.example.gyere.footballdata.di.Network;
import com.example.gyere.footballdata.interactor.Team.Events.GetTeamDetailsEvent;
import com.example.gyere.footballdata.interactor.Team.TeamInteractor;
import com.example.gyere.footballdata.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class DetailsPresenter extends Presenter<DetailsScreen> {

    @Inject
    TeamInteractor teamInteractor;

    @Inject
    @Network
    Executor networkExecutor;

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
        FootballDataApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void showDetails(final int id) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                teamInteractor.getTeam(id);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetTeamDetailsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                //screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showDetails(event.getTeam());
            }
        }
    }
}
