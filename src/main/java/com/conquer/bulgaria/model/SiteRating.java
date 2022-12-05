package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SiteRating {
    private final int count;

    private final int total;

    public SiteRating(@JsonProperty("count") int count,
                      @JsonProperty("total") int total) {
        this.count = count;
        this.total = total;
    }

    @JsonProperty("count")
    public int getCount() {
        return count;
    }

    @JsonProperty("total")
    public int getTotal() {
        return total;
    }
}
