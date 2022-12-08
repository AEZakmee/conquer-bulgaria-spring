package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record SiteInformation(@NotBlank() String description,
                              @NotBlank() String name,
                              @NotBlank() String town) {
    public SiteInformation(@JsonProperty("description") String description,
                           @JsonProperty("name") String name,
                           @JsonProperty("town") String town) {

        this.description = description;
        this.name = name;
        this.town = town;
    }
}
