package com.luis.demo_jpa.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luis.demo_jpa.application.service.*;
import com.luis.demo_jpa.domain.Person;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    @Override
    public List<Person> findAllByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        }
        else if (filter.toLowerCase().equals("language") && !value.isEmpty()){
            return personRepository.findByLanguageEquals(value);
        }
        return personRepository.findAll();
    }

}
