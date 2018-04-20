package com.example.gyere.footballdata.interactor.Team.Events;

import com.example.gyere.footballdata.model.Team;

public class SaveTeamEvent {
    private int code;
    private Team team;
    private Throwable throwable;

    public SaveTeamEvent() {
    }

    public SaveTeamEvent(int code, Team team, Throwable throwable) {
        this.code = code;
        this.team = team;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
