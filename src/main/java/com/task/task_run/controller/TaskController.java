package com.task.task_run.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.task_run.model.Task;
import com.task.task_run.service.InitService;
import com.task.task_run.service.TaskService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final InitService initService;

    public TaskController(TaskService taskService, InitService initService) {
        this.taskService = taskService;
        this.initService = initService;
    }

    private String getClientId(HttpServletRequest request) {
        String clientId = request.getHeader("X-Client-Id");
        if (clientId == null || clientId.isBlank()) {
            throw new RuntimeException("Missing X-Client-Id header");
        }
        return clientId;
    }

    @GetMapping
    public List<Task> recoverAll(HttpServletRequest request) {
        String clientId = getClientId(request);
        initService.initClientIfNeeded(clientId);
        return taskService.recoverAll(clientId);
    }

    @PostMapping
    public Task create(@RequestBody Task task, HttpServletRequest request) {
        return taskService.create(task, getClientId(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> modify(@PathVariable Long id, @RequestBody Task task, HttpServletRequest request) {
        return ResponseEntity.ok(taskService.modify(id, task, getClientId(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, HttpServletRequest request) {
        taskService.delete(id, getClientId(request));
        return ResponseEntity.noContent().build();
    }
}
