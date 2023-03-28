package com.codebyaz.romate.instruction;

import com.codebyaz.romate.action.Action;
import com.codebyaz.romate.locator.Locator;
import com.codebyaz.romate.process.Process;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int sequence;

    private String input;

    @Column(name = "locator_parameter")
    private String locatorParameter;

    @ManyToOne
    @JoinColumn(name = "process_id")
    private Process process;

    @ManyToOne
    @JoinColumn(name = "action_id")
    private Action action;

    @ManyToOne
    @JoinColumn(name = "locator_id")
    private Locator locator;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Instruction() {}

    public Instruction(Long id) {
        this.id = id;
    }

    public Instruction(int sequence, String input, String locatorParameter, Process process, Action action, Locator locator) {
        this.sequence = sequence;
        this.input = input;
        this.locatorParameter = locatorParameter;
        this.process = process;
        this.action = action;
        this.locator = locator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getLocatorParameter() {
        return locatorParameter;
    }

    public void setLocatorParameter(String locatorParameter) {
        this.locatorParameter = locatorParameter;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Locator getLocator() {
        return locator;
    }

    public void setLocator(Locator locator) {
        this.locator = locator;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
