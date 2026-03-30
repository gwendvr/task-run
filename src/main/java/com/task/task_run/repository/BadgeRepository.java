package com.task.task_run.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.task_run.model.Badge;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
    Optional<Badge> findByNom(String name);
}