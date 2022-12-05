package com.conquer.bulgaria.dao.person;

import com.conquer.bulgaria.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakeDAO")
public class FakePersonDataAccessService implements PersonDao {

    private static final List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID uuid, Person person) {
        DB.add(new Person(uuid, person.getName()));
        return 0;
    }

    @Override
    public List<Person> getPeople() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID uuid) {
        //DB.removeIf(person -> person.getId().equals(uuid));
        final Optional<Person> person = getPersonById(uuid);
        if(person.isEmpty()) {
            return 0;
        }
        DB.remove(person.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID uuid, Person person) {
        getPersonById(uuid).map(p -> {
            int index = DB.indexOf(p);
            if(index>=0) {
                DB.set(index, new Person(uuid, person.getName()));
                return 1;
            }
            return 0;
        });
        return 0;
    }

    @Override
    public Optional<Person> getPersonById(UUID uuid) {
        return DB.stream().filter(person -> person.getId().equals(uuid)).findFirst();
    }
}
