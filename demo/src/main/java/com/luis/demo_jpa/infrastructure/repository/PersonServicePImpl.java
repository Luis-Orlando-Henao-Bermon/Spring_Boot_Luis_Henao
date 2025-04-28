package com.luis.demo_jpa.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luis.demo_jpa.application.service.PersonService;
import com.luis.demo_jpa.domain.Person;

@Service
public class PersonServicePImpl implements PersonService{

    @Override
    public List<Person> findAllByFilter(String filter, String value) {
        return List.of(new Person(1L,"Luis","Henao","Python"));
    }

}
