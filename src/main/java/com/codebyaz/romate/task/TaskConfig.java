package com.codebyaz.romate.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner processCommandLineRunner(TaskRepository taskRepository) {

        return args -> {
            Task task = new Task("Pay electricity bill");

            taskRepository.saveAll(List.of(task));
        };
    }
}
