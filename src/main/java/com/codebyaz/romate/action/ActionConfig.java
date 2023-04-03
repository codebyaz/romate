package com.codebyaz.romate.action;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.codebyaz.romate.action.ActionsEnum.*;

@Configuration
public class ActionConfig {

    @Bean
    CommandLineRunner actionCommandLineRunner (ActionRepository actionRepository) {
        return args -> {

            Action type = new Action(
                    "Type",
                    TYPE,
                    "Enter some input text to a desired element."
            );

            Action click = new Action(
                    "Click",
                    CLICK,
                    "Click on a desired element."
            );

            Action get = new Action(
                    "Go to website",
                    NAVIGATE,
                    "Navigate to a desired website."
            );

            actionRepository.saveAll(
                    List.of(type,
                            click,
                            get
                    )
            );

        };
    }
}
