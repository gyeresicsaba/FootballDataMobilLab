package com.example.gyere.footballdata.model;

import com.google.gson.annotations.SerializedName;

public class Player   {

    @SerializedName("id")
    private Long id = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("position")
    private String position = null;

    @SerializedName("jerseyNumber")
    private Long jerseyNumber = null;

    @SerializedName("dateOfBirth")
    private String dateOfBirth = null;

    @SerializedName("nationality")
    private String nationality = null;

    @SerializedName("contractUntil")
    private String contractUntil = null;

    @SerializedName("marketValue")
    private String marketValue = null;


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


    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }


    public Long getJerseyNumber() {
        return jerseyNumber;
    }
    public void setJerseyNumber(Long jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getContractUntil() {
        return contractUntil;
    }
    public void setContractUntil(String contractUntil) {
        this.contractUntil = contractUntil;
    }

    public String getMarketValue() {
        return marketValue;
    }
    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Player {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    position: ").append(toIndentedString(position)).append("\n");
        sb.append("    jerseyNumber: ").append(toIndentedString(jerseyNumber)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
        sb.append("    contractUntil: ").append(toIndentedString(contractUntil)).append("\n");
        sb.append("    marketValue: ").append(toIndentedString(marketValue)).append("\n");
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
