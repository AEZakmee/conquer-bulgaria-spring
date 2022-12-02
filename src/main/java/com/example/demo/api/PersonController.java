package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private  final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person) {
         personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") UUID uuid) {
        return personService.deletePersonById(uuid);
    }

    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") UUID uuid, @Valid @NonNull @RequestBody Person person) {
        return personService.updatePersonById(uuid, person);
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID uuid) {
        return personService.getPersonById(uuid).orElse(null);
    }
}
