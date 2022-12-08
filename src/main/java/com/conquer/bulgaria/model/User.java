package com.conquer.bulgaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(String uid, String name, String email, long lastLogin, String bio) {

    public User(@JsonProperty("uid") String uid,
                @JsonProperty("name") String name,
                @JsonProperty("email") String email,
                @JsonProperty("lastLogin") long lastLogin,
                @JsonProperty("bio") String bio) {

        this.uid = uid;
        this.name = name;
        this.email = email;
        this.lastLogin = lastLogin;
        this.bio = bio;
    }
}
