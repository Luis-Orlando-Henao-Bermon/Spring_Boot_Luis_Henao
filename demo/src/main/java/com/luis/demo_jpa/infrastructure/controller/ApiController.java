package com.luis.demo_jpa.infrastructure.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luis.demo_jpa.application.service.PersonService;
import com.luis.demo_jpa.domain.Person;
import com.luis.demo_jpa.domain.Project;
import com.luis.demo_jpa.domain.Rol;
import com.luis.demo_jpa.domain.RoleRquest;
import com.luis.demo_jpa.infrastructure.repository.ProjectServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonService personService;
    private final ProjectServiceImpl projectServiceImpl;

    

    public ApiController(@Qualifier("personServiceImpl")PersonService personService,ProjectServiceImpl projectServiceImpl) {
        this.personService = personService;
        this.projectServiceImpl=projectServiceImpl;
    }



    @GetMapping("/users")    
    public List<Person> findAllUser(
        @RequestParam(defaultValue = "") String filter,
        @RequestParam(defaultValue = "") String value

    ){
        List<Person> results= personService.findAllUsersByFilter(filter,value);
        return results;
    }
    
    @GetMapping("/roles")    
    public List<Rol> findAllRoles(
        @RequestParam(defaultValue = "") String filter,
        @RequestParam(defaultValue = "") String value

    ){
        List<Rol> results= personService.findAllRolByFilter(filter,value);
        return results;
    }
    
    @PostMapping("/roles")
    public Map<String,Object> newRole(@RequestBody RoleRquest role){
        return Map.of("ID",role.getId(),"NAME",role.getName());
    }

    @GetMapping("/projects")    
    public List<Project> findAllProjects(){
        return projectServiceImpl.findAllProjects();
    }

}
