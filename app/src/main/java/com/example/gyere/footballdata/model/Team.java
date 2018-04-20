package com.example.gyere.footballdata.model;

import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("id")
    private Long id = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("shortName")
    private String shortName = null;

    @SerializedName("squadMarketValue")
    private String squadMarketValue = null;

    @SerializedName("crestUrl")
    private String crestUrl = null;

    @SerializedName("playersUrl")
    private String playersUrl = null;


    public Team() {

    }

    public Team(Long id, String name, String shortName, String squadMarketValue, String crestUrl,
                String playersUrl) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public String getPlayersUrl() {
        return playersUrl;
    }

    public void setPlayersUrl(String playersUrl) {
        this.playersUrl = playersUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Team {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    shortName: ").append(toIndentedString(shortName)).append("\n");
        sb.append("    squadMarketValue: ").append(toIndentedString(squadMarketValue)).append("\n");
        sb.append("    crestUrl: ").append(toIndentedString(crestUrl)).append("\n");
        sb.append("    playersUrl: ").append(toIndentedString(playersUrl)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
