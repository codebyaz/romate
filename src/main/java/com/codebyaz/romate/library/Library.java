package com.codebyaz.romate.library;

import com.codebyaz.romate.action.Action;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
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
}
