package com.example.gyere.footballdata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamsResult {
    @SerializedName("artists")
    @Expose
    private Teams teams;

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }
}
