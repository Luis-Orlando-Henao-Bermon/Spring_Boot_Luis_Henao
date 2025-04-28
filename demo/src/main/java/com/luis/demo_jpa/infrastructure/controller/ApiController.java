package com.luis.demo_jpa.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luis.demo_jpa.application.service.PersonService;
import com.luis.demo_jpa.domain.Person;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonService personService;

    

    public ApiController(@Qualifier("personServiceImpl")PersonService personService) {
        this.personService = personService;
    }



    @GetMapping("users")    
    public List<Person> findAll(
        @RequestParam(defaultValue = "") String filter,
        @RequestParam(defaultValue = "") String value

    ){
        List<Person> results= personService.findAllByFilter(filter,value);
        return results;
    }

}
