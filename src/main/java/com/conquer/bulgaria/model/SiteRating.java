package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SiteRating(int count,
                         int total) {
    public SiteRating(@JsonProperty("count") int count,
                      @JsonProperty("total") int total) {

        this.count = count;
        this.total = total;
    }
}
