package com.codebyaz.romate.action;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ActionConfig {

    @Bean
    CommandLineRunner actionCommandLineRunner (ActionRepository actionRepository) {
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

            Action checkElement = new Action(
                    "Check element",
                    "checkElement",
                    "Validate and return true if an element exists.",
                    true,
                    true
            );

            Action validateScreen = new Action(
                    "Check current screen",
                    "checkElement",
                    "Check if the screen is the intended one",
                    true,
                    true
            );

            actionRepository.saveAll(
                    List.of(type,
                            click,
                            get,
                            checkElement,
                            validateScreen
                    )
            );

        };
    }
}
