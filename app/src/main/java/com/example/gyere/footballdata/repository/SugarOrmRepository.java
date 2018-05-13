package com.example.gyere.footballdata.repository;

import android.content.Context;

import com.example.gyere.footballdata.model.Team;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Team> getTeams() {
        return SugarRecord.listAll(Team.class);
    }

    @Override
    public void saveTeam(Team team) {
        SugarRecord.saveInTx(team);
    }

    @Override
    public void updateTeams(List<Team> teams) {
        List<Team> myTeams = getTeams();
        List<Team> toUpdate = new ArrayList<>(myTeams.size());
        for (Team myTeam : myTeams) {
            for (Team team : teams) {
                if (team.getId() == myTeam.getId()) {
                    toUpdate.add(team);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeTeam(Team team) {
        SugarRecord.deleteInTx(team);
    }

    @Override
    public boolean isInDB(Team team) {
        return SugarRecord.findById(Team.class, team.getId()) != null;
    }
}
