package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Site {
    private final UUID uuid;
    @NotBlank()
    private final String siteNumber;
    @NotNull()
    private final SiteCoordinates coordinates;
    @NotNull()
    private final SiteInformation information;
    private final SiteRating rating;

    public Site(@JsonProperty("uuid") UUID uuid,
                @JsonProperty("siteNumber") String siteNumber,
                @JsonProperty("coordinates") SiteCoordinates coordinates,
                @JsonProperty("info") SiteInformation information,
                @JsonProperty("rating") SiteRating rating) {

        this.uuid = uuid;
        this.siteNumber = siteNumber;
        this.coordinates = coordinates;
        this.information = information;

        if(rating == null) {
            rating = new SiteRating(0, 0);
        }

        this.rating = rating;
    }

    public String getSiteNumber() {
        return siteNumber;
    }

    public UUID getUuid() {
        return uuid;
    }

    public SiteCoordinates getCoordinates() {
        return coordinates;
    }

    public SiteInformation getInformation() {
        return information;
    }

    public SiteRating getRating() {
        return rating;
    }
}
