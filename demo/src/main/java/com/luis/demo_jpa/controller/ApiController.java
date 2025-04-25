package com.luis.demo_jpa.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luis.demo_jpa.domain.Person;
import com.luis.demo_jpa.repository.PersonRepository;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonRepository personRepository;

    

    public ApiController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    @GetMapping("users")    
    public List<Person> findAll(){
        List<Person> results= personRepository.findById(2);
        return results;
    }

}
