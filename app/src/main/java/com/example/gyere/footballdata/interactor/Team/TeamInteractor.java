package com.example.gyere.footballdata.interactor.Team;

import com.example.gyere.footballdata.FootballDataApplication;
import com.example.gyere.footballdata.interactor.Team.Events.GetTeamDetailsEvent;
import com.example.gyere.footballdata.interactor.Team.Events.GetTeamEvent;
import com.example.gyere.footballdata.interactor.Team.Events.RemoveTeamEvent;
import com.example.gyere.footballdata.interactor.Team.Events.SaveTeamEvent;
import com.example.gyere.footballdata.model.Team;
import com.example.gyere.footballdata.model.TeamsResponse;
import com.example.gyere.footballdata.network.NetworkConfig;
import com.example.gyere.footballdata.network.TeamApi;
import com.example.gyere.footballdata.repository.Repository;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class TeamInteractor {

    @Inject
    Repository repository;
    @Inject
    TeamApi teamApi;

    public TeamInteractor() {
        FootballDataApplication.injector.inject(this);
    }

    public void getTeams() {
        GetTeamEvent event = new GetTeamEvent();
        try {
            Call<TeamsResponse> teamsCall = teamApi.getTeams(NetworkConfig.AUTH_TOKEN);
            Response<TeamsResponse> response = teamsCall.execute();
            if (response.code() != 200) {
                event.setTeam(repository.getTeams());
//                throw new Exception("Result code is not 200");
            } else {
                event.setCode(response.code());
                event.setTeam(response.body().getTeams());
                repository.updateTeams(response.body().getTeams());
            }
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void getTeam(int id) {
        GetTeamDetailsEvent event = new GetTeamDetailsEvent();
        try {
            Call<Team> teamCall = teamApi.getTeamById(id, NetworkConfig.AUTH_TOKEN);
            Response<Team> response = teamCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setTeam(response.body());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void saveTeam(Team team) {
        SaveTeamEvent event = new SaveTeamEvent();
        event.setTeam(team);
        try {
            repository.saveTeam(team);
            //Currently don't care about network sync problems
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
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
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
