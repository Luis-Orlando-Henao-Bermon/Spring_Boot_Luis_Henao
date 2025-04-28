package com.luis.demo_jpa.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.demo_jpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person,Long>{  
    List<Person> findByNameContains(String name);
    List<Person> findByLanguageEquals(String name);
    List<Person> findById(long id);

}
