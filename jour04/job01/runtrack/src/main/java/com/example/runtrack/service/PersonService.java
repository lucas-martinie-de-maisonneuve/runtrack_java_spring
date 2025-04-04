    package com.example.runtrack.service;

    import com.example.runtrack.model.PersonModel;
    import com.example.runtrack.repository.PersonRepository;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class PersonService {

        private PersonRepository personRepository;
        private PasswordEncoder passwordEncoder;

        public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
            this.personRepository = personRepository;
            this.passwordEncoder = passwordEncoder;
        }

        public List<PersonModel> getAllUsers() {
            return personRepository.findAll();
        }

        public Optional<PersonModel> getUserById(Long id) {
            return personRepository.findById(id);
        }

        public PersonModel getUserByUsername(String username) {
            return personRepository.findByUsername(username);
        }

        public PersonModel createUser(PersonModel person) {
            person.setPassword(passwordEncoder.encode(person.getPassword()));
            return personRepository.save(person);
        }

        public void deleteUser(Long id) {
            personRepository.deleteById(id);
        }
    }
