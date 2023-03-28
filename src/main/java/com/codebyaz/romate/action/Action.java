package com.codebyaz.romate.action;

import jakarta.persistence.*;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String slug;

    private String description;

    @Column(name = "has_input")
    private boolean hasInput;

    @Column(name = "has_locator")
    private boolean hasLocator;

    public Action() {}

    public Action(Long id) { this.id = id; }

    public Action(String name, String slug, String description, boolean hasInput, boolean hasLocator) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.hasInput = hasInput;
        this.hasLocator = hasLocator;
    }

    public Action(Long id, String name, String slug, String description, boolean hasInput, boolean hasLocator) {
        this.id = id;
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.hasInput = hasInput;
        this.hasLocator = hasLocator;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean hasInput() {
        return hasInput;
    }

    public void setHasInput(boolean hasInput) {
        this.hasInput = hasInput;
    }

    public boolean hasLocator() {
        return hasLocator;
    }

    public void setHasLocator(boolean hasLocator) {
        this.hasLocator = hasLocator;
    }
}
