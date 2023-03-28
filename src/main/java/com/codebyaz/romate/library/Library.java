package com.codebyaz.romate.library;

import com.codebyaz.romate.action.Action;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String slug;

    private String description;

    @Column(name = "is_custom")
    private boolean isCustom;

    @ManyToMany
    private List<Action> actions;

    public Library() {}

    public Library(Long id) {
        this.id = id;
    }

    public Library(String name, String slug, String description, boolean isCustom, List<Action> actions) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.isCustom = isCustom;
        this.actions = actions;
    }

    public Library(Long id, String name, String slug, String description, boolean isCustom, List<Action> actions) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.isCustom = isCustom;
        this.actions = actions;
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

    public boolean isCustom() {
        return isCustom;
    }

    public void setCustom(boolean custom) {
        isCustom = custom;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
