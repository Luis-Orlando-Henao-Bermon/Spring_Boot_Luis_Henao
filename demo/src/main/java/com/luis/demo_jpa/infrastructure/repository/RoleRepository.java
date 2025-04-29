package com.luis.demo_jpa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.demo_jpa.domain.Rol;

public interface RoleRepository extends JpaRepository<Rol,Long>{

    

}
