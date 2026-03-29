package com.task.task_run.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.task_run.model.Badge;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
}