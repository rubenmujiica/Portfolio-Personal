package com.portfolio.my_portfolio_backend_ruben.service;

import com.portfolio.my_portfolio_backend_ruben.model.Project;

import java.util.List;

public interface IProjectService {
    List<Project> findAll();
    Project save(Project project);
}
