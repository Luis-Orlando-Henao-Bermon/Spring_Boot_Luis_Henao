package com.luis.demo_jpa.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luis.demo_jpa.application.service.*;
import com.luis.demo_jpa.domain.Person;
import com.luis.demo_jpa.domain.Rol;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;



    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }



    @Override
    public List<Person> findAllUsersByFilter(String filter, String value) {
        if (filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        }
        else if (filter.toLowerCase().equals("language") && !value.isEmpty()){
            return personRepository.findByLanguageEquals(value);
        }
        return personRepository.findAll();
    }



    @Override
    public List<Rol> findAllRolByFilter(String filter, String value) {
        
        return roleRepository.findAll();
    }

}
