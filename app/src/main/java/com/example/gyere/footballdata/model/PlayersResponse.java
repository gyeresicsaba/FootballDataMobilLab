package com.example.gyere.footballdata.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PlayersResponse   {

    @SerializedName("count")
    private Integer count = null;

    @SerializedName("players")
    private List<Player> players = new ArrayList<Player>();


    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PlayersResponse {\n");

        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    players: ").append(toIndentedString(players)).append("\n");
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
