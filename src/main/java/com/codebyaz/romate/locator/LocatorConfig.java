package com.codebyaz.romate.locator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LocatorConfig {

    @Bean
    CommandLineRunner locationCommandLineRunner (LocatorRepository locatorRepository) {
        return args -> {
            Locator textLocator = new Locator(
                    "text",
                    "text"
            );

            Locator idLocator = new Locator(
                    "HTML attribute: id",
                    "id"
            );

            Locator nameLocator = new Locator(
                    "HTML attribute: name",
                    "name"
            );

            locatorRepository.saveAll(List.of(textLocator, idLocator, nameLocator));
        };
    }
}
