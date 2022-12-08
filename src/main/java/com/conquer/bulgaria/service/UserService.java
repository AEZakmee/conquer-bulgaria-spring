package com.conquer.bulgaria.service;

import com.conquer.bulgaria.dao.user.UserDao;
import com.conquer.bulgaria.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("userPostgres") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public Optional<User> getUser(String uid) {
        return userDao.getUser(uid);
    }
}
