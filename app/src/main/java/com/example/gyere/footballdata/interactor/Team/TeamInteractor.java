package com.example.gyere.footballdata.interactor.Team;

import com.example.gyere.footballdata.interactor.Team.Events.GetTeamEvent;
import com.example.gyere.footballdata.interactor.Team.Events.RemoveTeamEvent;
import com.example.gyere.footballdata.interactor.Team.Events.SaveTeamEvent;
import com.example.gyere.footballdata.model.Team;
import com.example.gyere.footballdata.repository.Repository;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

public class TeamInteractor {
    @Inject
    EventBus bus;
    @Inject
    Repository repository;

    public TeamInteractor() {
        injector.inject(this);
    }

    public void getTeams() {
        GetTeamEvent event = new GetTeamEvent();
        try {
            List<Team> teams = repository.getTeams();
            event.setTeam(teams);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveTeam(Team team) {
        SaveTeamEvent event = new SaveTeamEvent();
        event.setTeam(team);
        try {
            repository.saveTeam(team);
            //Currently don't care about network sync problems
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateTeams(List<Team> teams) {
        try {
            repository.updateTeams(teams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeTeams(Team team) {
        RemoveTeamEvent event = new RemoveTeamEvent();
        event.setTeam(team);
        try {
            repository.removeTeam(team);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
