package com.portfolio.my_portfolio_backend_ruben.repository;

import com.portfolio.my_portfolio_backend_ruben.model.Experience;
import com.portfolio.my_portfolio_backend_ruben.model.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectRepository {
    List<Project> findAll();
    Optional<Project> findById(Long id);
    Project save(Project project);
    void deleteById(Long id);
    List<Project> findByPersonalInfoId(Long personalInfoId);
}
