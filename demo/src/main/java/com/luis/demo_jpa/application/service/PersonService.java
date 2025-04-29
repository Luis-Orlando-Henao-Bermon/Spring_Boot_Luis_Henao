package com.luis.demo_jpa.application.service;

import java.util.List;
import com.luis.demo_jpa.domain.Person;
import com.luis.demo_jpa.domain.Rol;

public interface PersonService {

    public List<Person> findAllUsersByFilter(String filter,String value);
    public List<Rol> findAllRolByFilter(String filter,String value);

}