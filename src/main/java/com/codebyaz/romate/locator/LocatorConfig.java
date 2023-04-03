package com.codebyaz.romate.locator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.codebyaz.romate.locator.LocatorsEnum.*;

@Configuration
public class LocatorConfig {

    @Bean
    CommandLineRunner locationCommandLineRunner (LocatorRepository locatorRepository) {

        return args -> {
            Locator css = new Locator(
                    "Css",
                    "Locates elements matching a CSS selector",
                    CSS_SELECTOR
            );

            Locator id = new Locator(
                    "Id",
                    "Locates elements whose ID attribute matches the search value",
                    ID
            );

            Locator name = new Locator(
                    "Name",
                    "Locates elements whose NAME attribute matches the search value",
                    NAME
            );

            Locator className = new Locator(
                    "Css class",
                    "Locates elements whose class name contains the search value (compound class names are not permitted)",
                    CLASS
            );

            Locator htmlTag = new Locator(
                    "HTML tag",
                    "Locates elements whose tag name matches the search value",
                    TAG
            );

            Locator linkText = new Locator(
                    "Link text",
                    "Locates anchor elements whose visible text matches the search value",
                    LINK_TEXT
            );

            Locator partialLinkText = new Locator(
                    "Partial link text",
                    "Locates anchor elements whose visible text contains the search value. If multiple elements are matching, only the first one will be selected",
                    PARTIAL_LINK_TEXT
            );

            Locator xpath = new Locator(
                    "Partial link text",
                    "Locates elements matching an XPath expression",
                    XPATH
            );

            locatorRepository.saveAll(
                    List.of(
                            name,
                            className,
                            css,
                            htmlTag,
                            id,
                            linkText,
                            partialLinkText,
                            xpath
                    ));
        };
    }
}
