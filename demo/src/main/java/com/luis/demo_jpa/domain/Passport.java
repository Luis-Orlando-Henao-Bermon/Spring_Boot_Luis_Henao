package com.luis.demo_jpa.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50,nullable = false)
    private String number;


    @OneToOne
    @JoinColumn(name = "Person_id")
    @JsonBackReference
    private Person person;

    private Date expiration;

    public Passport(){}

    public Passport(Long id, String number, Date expiration) {
        this.id = id;
        this.number = number;
        this.expiration = expiration;
    }

    
}
