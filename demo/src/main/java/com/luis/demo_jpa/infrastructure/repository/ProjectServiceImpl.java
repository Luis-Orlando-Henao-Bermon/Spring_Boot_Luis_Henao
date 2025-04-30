package com.luis.demo_jpa.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luis.demo_jpa.application.service.ProjectService;
import com.luis.demo_jpa.domain.Project;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }



    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

}
