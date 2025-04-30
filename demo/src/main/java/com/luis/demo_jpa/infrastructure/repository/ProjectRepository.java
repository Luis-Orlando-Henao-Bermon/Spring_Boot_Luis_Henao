package com.luis.demo_jpa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luis.demo_jpa.domain.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{
    
}
