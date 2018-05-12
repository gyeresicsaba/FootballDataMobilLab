package com.example.gyere.footballdata.interactor.Team.Events;

import com.example.gyere.footballdata.model.Team;
import com.example.gyere.footballdata.model.TeamsResponse;

import java.util.List;

public class GetTeamEvent {
    private int code;
    private List<Team> teams;
    private Throwable throwable;

    public GetTeamEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Team> getTeam() {
        return teams;
    }

    public void setTeam(List<Team> teams) {
        this.teams = teams;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
