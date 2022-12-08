package com.conquer.bulgaria.dao.user;

import com.conquer.bulgaria.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userPostgres")
public class UserRepository implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(User user) {
        String sql = "" +
                "INSERT INTO users (" +
                " uid, " +
                " name, " +
                " email, " +
                " lastLogin, " +
                " bio)" +
                "VALUES(?,?,?,?,?)";

        return jdbcTemplate.update(
                sql,
                user.uid(),
                user.name(),
                user.email(),
                user.lastLogin(),
                user.bio()
        );
    }

    @Override
    public Optional<User> getUser(String uid) {
        final String sql = "Select uid, name, email, lastLogin, bio FROM users WHERE uid = ?";
        return Optional.ofNullable((User) jdbcTemplate.queryForObject(
                sql,
                new Object[]{uid},
                (resultSet, i) -> {
                    return new User(
                            resultSet.getString("uid"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            Long.parseLong(resultSet.getString("lastLogin")),
                            resultSet.getString("bio")
                    );
                }));
    }
}
