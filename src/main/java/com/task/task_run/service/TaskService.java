package com.task.task_run.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task.task_run.model.Task;
import com.task.task_run.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> recoverAll() {
        return taskRepository.findAll();
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task modify(Long id, Task updatedTask) {
        updatedTask.setId(id);
        return taskRepository.save(updatedTask);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
