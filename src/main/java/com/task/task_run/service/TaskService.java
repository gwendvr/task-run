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

    public List<Task> recoverAll(String clientId) {
        return taskRepository.findByClientId(clientId);
    }

    public Task create(Task task, String clientId) {
        task.setClientId(clientId);
        return taskRepository.save(task);
    }

    public Task modify(Long id, Task updatedTask, String clientId) {
        return taskRepository.findByIdAndClientId(id, clientId)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setStatut(updatedTask.getStatut());
                    task.setDueDate(updatedTask.getDueDate());
                    task.setPriorite(updatedTask.getPriorite());
                    task.setTags(updatedTask.getTags());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void delete(Long id, String clientId) {
        taskRepository.deleteByIdAndClientId(id, clientId);
    }
}
