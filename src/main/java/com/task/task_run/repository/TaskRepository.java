package com.task.task_run.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.task_run.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
