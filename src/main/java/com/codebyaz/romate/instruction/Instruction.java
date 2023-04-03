package com.codebyaz.romate.instruction;

import com.codebyaz.romate.action.Action;
import com.codebyaz.romate.locator.Locator;
import com.codebyaz.romate.task.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.By;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int sequence;
    private String input;
    @Column(name = "locator_parameter")
    private String locatorParameter;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
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

    public Instruction(Long id) {}

    public Instruction(Task task) {}

    public Instruction(int sequence, String input, String locatorParameter, Task task, Action action, Locator locator) {
        this.sequence = sequence;
        this.input = input;
        this.locatorParameter = locatorParameter;
        this.task = task;
        this.action = action;
        this.locator = locator;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "id=" + id +
                ", sequence=" + sequence +
                ", input='" + input + '\'' +
                ", task=" + task +
                ", action=" + action +
                ", locator=" + locator +
                ", createdAt=" + createdAt +
                '}';
    }
}
