package com.luis.demo_jpa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "personas")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name",columnDefinition = "TEXT",length = 50,nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    @JsonBackReference
    private Rol role;
    
    private String lastname;
    
    @Column(name = "programingLanguage")
    private String language;

    public Person() {
    }

    public Person(long id, String name, String lastname, String language) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.language = language;
    }

}
