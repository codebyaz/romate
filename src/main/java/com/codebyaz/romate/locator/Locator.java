package com.codebyaz.romate.locator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.By;

@Entity
@Data
@AllArgsConstructor
public class Locator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocatorsEnum slug;

    public Locator() {}

    public Locator(Long id) {
        this.id = id;
    }

    public Locator(String name, String description, LocatorsEnum slug) {
        this.name = name;
        this.description = description;
        this.slug = slug;
    }

    public Locator(Long id, String name, String description, LocatorsEnum slug, String parameter) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.slug = slug;
    }

    public By get(String parameter) {
        switch(this.getSlug()) {
            case ID:
                return By.id(parameter);
            case NAME:
                return By.name(parameter);
            case CSS_SELECTOR:
                return By.cssSelector(parameter);
            case TAG:
                return By.tagName(parameter);
            case CLASS:
                return By.className(parameter);
            case LINK_TEXT:
                return By.linkText(parameter);
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(parameter);
            case XPATH:
                return By.xpath(parameter);
        }

        return null;
    }

}
