package com.task.task_run.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.task_run.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByClientId(String clientId);
}