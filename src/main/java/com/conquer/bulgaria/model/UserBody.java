package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record UserBody (@NotBlank() String username,
                        @NotBlank() String bio) {

    public UserBody(@JsonProperty("username") String username,
                    @JsonProperty("bio") String bio) {

        this.username = username;
        this.bio = bio;
    }
}
