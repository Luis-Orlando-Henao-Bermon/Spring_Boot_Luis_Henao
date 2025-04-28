package com.luis.demo_jpa.application.service;

import java.util.List;
import com.luis.demo_jpa.domain.Person;

public interface PersonService {

    public List<Person> findAllByFilter(String filter,String value);

}
