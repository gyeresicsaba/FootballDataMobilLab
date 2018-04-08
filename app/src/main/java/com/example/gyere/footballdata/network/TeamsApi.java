package com.example.gyere.footballdata.network;

import com.example.gyere.footballdata.model.TeamsResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface TeamsApi {
    @GET("teams")
    Call<TeamsResult> getTeams(@Header("X-Auth-Token") String token);
}

