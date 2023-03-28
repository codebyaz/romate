package com.codebyaz.romate.process;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProcessConfig {

    @Bean
    CommandLineRunner processCommandLineRunner(ProcessRepository processRepository) {

        return args -> {
            Process process = new Process("Pay electricity bill");

            processRepository.saveAll(List.of(process));
        };
    }
}
