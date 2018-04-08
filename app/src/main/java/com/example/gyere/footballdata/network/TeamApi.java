package com.example.gyere.footballdata.network;

import com.example.gyere.footballdata.model.TeamsResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface TeamApi {
    @GET("teams/{id}")
    Call<TeamsResult> getTeam(@Header("X-Auth-Token") String token,
                              @Path("id") int teamId);
}
