package com.luis.demo_jpa.application.service;

import java.util.List;

import com.luis.demo_jpa.domain.Project;

public interface ProjectService {
    List<Project> findAllProjects();
}
