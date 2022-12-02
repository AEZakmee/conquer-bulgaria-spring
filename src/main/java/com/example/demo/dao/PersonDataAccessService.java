package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements  PersonDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID uuid, Person person) {
        String sql = "" +
                "INSERT INTO person (" +
                " id, " +
                " name)" +
                "VALUES(?,?)";

        return jdbcTemplate.update(
                sql,
                uuid,
                person.getName()
        );

    }

    @Override
    public List<Person> getPeople() {
        final String sql = "Select id, name FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Person(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name")
            );
        });
    }

    @Override
    public int deletePersonById(UUID uuid) {
        String sql = "" +
                "DELETE FROM person " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, uuid);
    }

    @Override
    public int updatePersonById(UUID uuid, Person person) {
        String sql = "" +
                "UPDATE person " +
                "SET name = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, person.getName(), uuid);
    }

    @Override
    public Optional<Person> getPersonById(UUID uuid) {
        final String sql = "Select id, name FROM person WHERE id = ?";
        return Optional.ofNullable((Person) jdbcTemplate.queryForObject(
                sql,
                new Object[]{uuid},
                (resultSet, i) -> {
                    return new Person(
                            UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("name")
                    );
                }));
    }
}
