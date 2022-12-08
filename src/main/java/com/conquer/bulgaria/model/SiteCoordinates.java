package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public record SiteCoordinates(@NotNull() double lat,
                              @NotNull() double lng) {
    public SiteCoordinates(@JsonProperty("lat") double lat,
                           @JsonProperty("lng") double lng) {

        this.lat = lat;
        this.lng = lng;
    }
}
