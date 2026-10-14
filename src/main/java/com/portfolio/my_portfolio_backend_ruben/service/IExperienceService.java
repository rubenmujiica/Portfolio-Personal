package com.portfolio.my_portfolio_backend_ruben.service;

import com.portfolio.my_portfolio_backend_ruben.model.Experience;

import java.util.List;
import java.util.Optional;

public interface IExperienceService {
    Experience save(Experience experience);
    Optional<Experience> findById(Long id);
    List<Experience> findAll();
    void deleteById(Long id);
    List<Experience> findByPersonalInfoId(Long personalInfoId);
}
