package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {
    private final UUID uuid;
    @NotBlank(message = "Name should not be empty")
    private final String name;

    public Person(@JsonProperty("uuid") UUID uuid,
                  @JsonProperty("name") String name) {
        this.uuid = uuid;
        this.name = name;
    }

    @JsonProperty("uuid")
    public UUID getId() {
        return uuid;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
}
