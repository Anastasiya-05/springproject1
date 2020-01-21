package by.minenkova.springprogect1.service;

import by.minenkova.springprogect1.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPerson();
    void addNewPerson(Person person);
    void deletePerson(Person person );
    void editPerson(Person person);
    Optional<Person> getById(long id);
}
