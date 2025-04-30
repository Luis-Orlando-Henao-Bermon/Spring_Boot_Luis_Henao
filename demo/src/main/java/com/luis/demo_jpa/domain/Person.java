package com.luis.demo_jpa.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Rol role;
    
    private String lastname;
    
    @Column(name = "programingLanguage")
    private String language;

    @OneToOne(mappedBy = "person")    
    @JsonManagedReference
    private Passport passport;


    @ManyToMany
    @JoinTable(name= "personas_proyects",
        joinColumns = @JoinColumn(name = "person_id",foreignKey = @ForeignKey(name="fk_persona_id_projects")),
        inverseJoinColumns = @JoinColumn(name="proyect_id")
    )
    @JsonBackReference
    private List<Project> projects =new ArrayList<>();

    public Person() {
    }

    public Person(long id, String name, String lastname, String language) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.language = language;
    }

}
