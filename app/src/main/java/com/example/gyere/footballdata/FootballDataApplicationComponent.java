package com.example.gyere.footballdata;

import com.example.gyere.footballdata.interactor.InteractorModule;
import com.example.gyere.footballdata.interactor.Team.TeamInteractor;
import com.example.gyere.footballdata.network.NetworkModule;
import com.example.gyere.footballdata.repository.RepositoryModule;
import com.example.gyere.footballdata.ui.UIModule;
import com.example.gyere.footballdata.ui.details.DetailsActivity;
import com.example.gyere.footballdata.ui.details.DetailsPresenter;
import com.example.gyere.footballdata.ui.main.MainActivity;
import com.example.gyere.footballdata.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, InteractorModule.class, RepositoryModule.class})
public interface FootballDataApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(DetailsActivity detailsActivity);

    void inject(TeamInteractor teamInteractor);

    void inject(MainPresenter mainPresenter);

    void inject(DetailsPresenter detailsPresenter);

}
