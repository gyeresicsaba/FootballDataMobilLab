package com.example.gyere.footballdata.repository;

import android.content.Context;

import com.example.gyere.footballdata.model.Team;

import java.util.List;

public interface Repository {
    void open(Context context);

    void close();

    List<Team> getTeams();

    void saveTeam(Team team);

    void updateTeams(List<Team> teams);

    void removeTeam(Team team);

    boolean isInDB(Team team);
}
