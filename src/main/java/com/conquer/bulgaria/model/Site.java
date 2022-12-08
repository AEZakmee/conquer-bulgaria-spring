package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record Site(UUID uuid,
                   @NotBlank() String siteNumber,
                   @NotNull() SiteCoordinates coordinates,
                   @NotNull() SiteInformation information,
                   SiteRating rating) {
    public Site(@JsonProperty("uuid") UUID uuid,
                @JsonProperty("siteNumber") String siteNumber,
                @JsonProperty("coordinates") SiteCoordinates coordinates,
                @JsonProperty("information") SiteInformation information,
                @JsonProperty("rating") SiteRating rating) {

        this.uuid = uuid;
        this.siteNumber = siteNumber;
        this.coordinates = coordinates;
        this.information = information;

        if (rating == null) {
            rating = new SiteRating(0, 0);
        }

        this.rating = rating;
    }
}
