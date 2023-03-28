package com.codebyaz.romate.library;

import com.codebyaz.romate.action.Action;
import com.codebyaz.romate.action.ActionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LibraryConfig {

    @Bean
    CommandLineRunner libraryCommandLineRunner(LibraryRepository libraryRepository, ActionRepository actionRepository) {
        return args -> {
            Action type = new Action(
                    "Type",
                    "type",
                    "Enter some input text to a desired element.",
                    true,
                    true
            );

            Action click = new Action(
                    "Click",
                    "click",
                    "Click on a desired element.",
                    false,
                    true
            );

            Action get = new Action(
                    "Go to website",
                    "get",
                    "Navigate to a desired website.",
                    true,
                    false
            );

            Library library = new Library(
                    "Sign in",
                    "signin",
                    "Actions to sign to a website",
                    false,
                    List.of(type, click)
            );

            actionRepository.saveAll(List.of(type, click));

            libraryRepository.save(library);
        };
    }
}
