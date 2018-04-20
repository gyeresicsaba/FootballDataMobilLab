package com.example.gyere.footballdata.interactor;

import com.example.gyere.footballdata.interactor.Team.TeamInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public TeamInteractor provideTeams() {
        return new TeamInteractor();
    }
}
