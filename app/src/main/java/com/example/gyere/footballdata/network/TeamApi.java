package com.example.gyere.footballdata.network;

import com.example.gyere.footballdata.model.Team;
import com.example.gyere.footballdata.model.TeamsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TeamApi {

    /**
     * List all players of a team
     *
     * @param apiKey
     * @return Call<Void>
     */

    @GET("players")
    Call<Void> getPlayers(
            @Header("api_key") String apiKey
    );


    /**
     * Find team by ID
     * Returns a single team
     * @param teamId ID of team to return
     * @param apiKey
     * @return Call<Team>
     */

    @GET("team/{teamId}")
    Call<Team> getTeamById(
            @Path("teamId") Long teamId, @Header("api_key") String apiKey
    );


    /**
     * Updates a team in the list with form data
     *
     * @param teamId Team id to delete
     * @param body Team object that needs to be added to the list
     * @param apiKey
     * @return Call<Void>
     */

    @PUT("team/{teamId}")
    Call<Void> updateTeam(
            @Path("teamId") Long teamId, @Body Team body, @Header("api_key") String apiKey
    );


    /**
     * Deletes a team
     *
     * @param teamId Team id to delete
     * @param apiKey
     * @return Call<Void>
     */

    @DELETE("team/{teamId}")
    Call<Void> deleteTeam(
            @Path("teamId") Long teamId, @Header("api_key") String apiKey
    );


    /**
     * List all teams
     *
     * @param apiKey
     * @return Call<Void>
     */

    @GET("teams")
    Call<TeamsResponse> getTeams(
            @Header("api_key") String apiKey
    );


    /**
     * Add a new team to the list
     *
     * @param body Team object that needs to be added to the list
     * @param apiKey
     * @return Call<Void>
     */

    @POST("teams")
    Call<Void> addTeam(
            @Body Team body, @Header("api_key") String apiKey
    );


}
