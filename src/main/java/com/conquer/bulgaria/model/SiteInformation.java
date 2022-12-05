package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SiteInformation {
    @NotBlank()
    private final String description;
    @NotBlank()
    private final String name;
    @NotBlank()
    private final String town;

    public SiteInformation(@JsonProperty("description") String description,
                           @JsonProperty("name") String name,
                           @JsonProperty("town") String town) {
        this.description = description;
        this.name = name;
        this.town = town;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("town")
    public String getTown() {
        return town;
    }
}
