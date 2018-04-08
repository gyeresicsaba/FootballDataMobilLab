package com.example.gyere.footballdata.model;

import java.util.ArrayList;
import java.util.List;

public class Teams {
    private int count;
    private List<Team> teams = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
