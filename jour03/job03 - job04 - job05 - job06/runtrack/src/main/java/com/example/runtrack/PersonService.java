package com.example.runtrack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(Person updatedPerson) {
        personRepository.findById(updatedPerson.getId()).ifPresent(person -> {
            person.setName(updatedPerson.getName());
            person.setAge(updatedPerson.getAge());
            personRepository.save(person);
        });
    }
}
