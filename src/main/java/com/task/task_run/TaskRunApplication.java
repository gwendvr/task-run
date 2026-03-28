package com.task.task_run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskRunApplication.class, args);
	}

}
