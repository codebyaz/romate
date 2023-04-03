package com.codebyaz.romate.action;

import com.codebyaz.romate.locator.Locator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;

@Entity
@Data
@AllArgsConstructor
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private ActionsEnum slug;
    private String description;
    @Transient
    private String input;

    public Action() {}

    public Action(Long id) {
        this.id = id;
    }

    public Action(String name, ActionsEnum slug, String description) {
        this.name = name;
        this.slug = slug;
        this.description = description;
    }
}
