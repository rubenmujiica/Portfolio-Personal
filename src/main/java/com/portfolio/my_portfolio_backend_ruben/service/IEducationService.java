package com.portfolio.my_portfolio_backend_ruben.service;

import com.portfolio.my_portfolio_backend_ruben.model.Education;

import java.util.List;
import java.util.Optional;

public interface IEducationService {
    Education save(Education education);
    Optional<Education> findById(Long id);
    List<Education> findAll();
    void deleteById(Long id);
    List<Education> findByPersonalInfoId(Long personalInfoId);
}
