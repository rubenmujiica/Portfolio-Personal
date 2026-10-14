package com.portfolio.my_portfolio_backend_ruben.repository;

import com.portfolio.my_portfolio_backend_ruben.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> findByUsername(String username);
}
