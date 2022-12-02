package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID uuid, Person person);

    List<Person> getPeople();

    int deletePersonById(UUID uuid);

    int updatePersonById(UUID uuid, Person person);

    Optional<Person> getPersonById(UUID uuid);

    default int insertPerson(Person person) {
        final UUID uuid = UUID.randomUUID();
        return insertPerson(uuid, person);
    }
}
