package com.task.task_run.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.task.task_run.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByClientId(String clientId);

    Optional<Task> findByIdAndClientId(Long id, String clientId);

    @Transactional
    void deleteByIdAndClientId(Long id, String clientId);
}
