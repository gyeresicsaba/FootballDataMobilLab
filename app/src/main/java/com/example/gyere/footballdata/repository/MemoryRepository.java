package com.example.gyere.footballdata.repository;

import android.content.Context;

import com.example.gyere.footballdata.model.Team;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepository implements Repository {
    private static final long MINUTE = 60 * 1000;

    public static List<Team> teams;

    @Override
    public void open(Context context) {
        Team team1 = new Team(1, "Manchester United", "ManU", "33333", "crestUrl", "playersUrl");
        Team team2 = new Team(1, "Real Madrid", "RM", "33333", "crestUrl", "playersUrl");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Team> getTeams() {
        return teams;
    }

    @Override
    public void saveTeam(Team team) {
        teams.add(team);
    }

    @Override
    public void updateTeams(List<Team> teams) {
        for (int i = 0; i < this.teams.size(); i++) {
            Team myTeam = this.teams.get(i);
            for (Team team : teams) {
                if (team.getId() == myTeam.getId()) {
                    this.teams.set(i, team);
                }
            }
        }
    }

    @Override
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    @Override
    public boolean isInDB(Team team) {
        return false;
    }
}
