package com.demo.application.registrationsimplewebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.application.registrationsimplewebapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
