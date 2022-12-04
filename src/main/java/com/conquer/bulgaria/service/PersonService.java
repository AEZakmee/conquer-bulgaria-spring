package com.conquer.bulgaria.service;

import com.conquer.bulgaria.dao.PersonDao;
import com.conquer.bulgaria.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private  final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getPeople() {
        return personDao.getPeople();
    }

    public int deletePersonById(UUID uuid) {
        return  personDao.deletePersonById(uuid);
    }

    public int updatePersonById(UUID uuid, Person person) {
        return  personDao.updatePersonById(uuid, person);
    }

    public Optional<Person> getPersonById(UUID uuid) {
        return personDao.getPersonById(uuid);
    }
}
