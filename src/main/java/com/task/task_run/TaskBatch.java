package com.task.task_run;

import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskBatch {
    private final TaskRepository taskRepository;

    public TaskBatch(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void marquerTachesExpirees() {
        List<Task> tasks = taskRepository.findAll();

        for (Task task : tasks) {
            if (task.getDueDate() != null && task.getDueDate().isBefore(LocalDate.now())) {
                task.setStatut("EXPIRE");
                taskRepository.save(task);
            }
        }
    }
}
