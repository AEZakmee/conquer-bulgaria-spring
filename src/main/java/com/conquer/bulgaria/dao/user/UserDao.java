package com.conquer.bulgaria.dao.user;

import com.conquer.bulgaria.model.User;

import java.util.Optional;

public interface UserDao {
    public int addUser(User user);
    public Optional<User> getUser(String uid);
}
