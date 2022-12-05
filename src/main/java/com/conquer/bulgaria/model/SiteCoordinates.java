package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class SiteCoordinates {
    @NotNull()
    private final double lat;
    @NotNull()
    private final double lng;

    public SiteCoordinates(@JsonProperty("lat") double lat,
                           @JsonProperty("lng") double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @JsonProperty("lat")
    public double getLat() {
        return lat;
    }

    @JsonProperty("lng")
    public double getLng() {
        return lng;
    }
}
