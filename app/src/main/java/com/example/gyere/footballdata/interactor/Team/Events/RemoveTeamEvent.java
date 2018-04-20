package com.example.gyere.footballdata.interactor.Team.Events;

import com.example.gyere.footballdata.model.Team;

public class RemoveTeamEvent {
    private int code;
    private Team session;
    private Throwable throwable;

    public RemoveTeamEvent() {
    }

    public RemoveTeamEvent(int code, Team session, Throwable throwable) {
        this.code = code;
        this.session = session;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Team getTeam() {
        return session;
    }

    public void setTeam(Team session) {
        this.session = session;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
