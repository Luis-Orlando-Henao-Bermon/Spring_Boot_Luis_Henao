package com.luis.demo_jpa.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luis.demo_jpa.application.service.PersonService;
import com.luis.demo_jpa.domain.Person;
import com.luis.demo_jpa.domain.Rol;

@Service
public class PersonServicePImpl implements PersonService{

    @Override
    public List<Person> findAllUsersByFilter(String filter, String value) {
        return List.of(new Person(1L,"Luis","Henao","Python"));
    }


    @Override
    public List<Rol> findAllRolByFilter(String filter, String value) {
        throw new UnsupportedOperationException("Unimplemented method 'findAllRolesByFilter'");
    }

}
