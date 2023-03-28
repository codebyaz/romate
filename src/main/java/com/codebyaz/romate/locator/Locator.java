package com.codebyaz.romate.locator;

import jakarta.persistence.*;
import org.openqa.selenium.By;

@Entity
@Table
public class Locator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String slug;

    public Locator() {}

    public Locator(Long id) { this.id = id; }
    public Locator(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public By transformToLocator(String parameter) {
        By locator;

        switch(this.slug) {
            case "id":
                locator = By.id(parameter);
                return locator;
            case "name":
                locator = By.name(parameter);
                return locator;
        }

        return null;
    }
}
