package com.example.runtrack.config;

import com.example.runtrack.model.Person;
import com.example.runtrack.repository.PersonRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Person person = personRepository.findByUsername(username);

        System.out.println("Stored password: " + person.getPassword());
        System.out.println("Provided password: " + password);

        if (!passwordEncoder.matches(password, person.getPassword())) {
            System.out.println("Password does not match!");
            throw new BadCredentialsException("Invalid password");
        } else {
            System.out.println("Password matches!");
        }

        UserDetails userDetails = User
                .withUsername(person.getUsername())
                .password(person.getPassword())
                .roles(person.getRole())
                .build();

        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
