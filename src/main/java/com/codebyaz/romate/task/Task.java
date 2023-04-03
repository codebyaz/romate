package com.codebyaz.romate.task;

import com.codebyaz.romate.instruction.Instruction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @Column(name = "is_private")
    private boolean isPrivate = false;
    @Column(name = "executions_in_parallel")
    private int executionsInParallel = 0;
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "task")
    List<Instruction> instructions;

    public Task() {}

    public Task(Long id) {
        this.id = id;
    }

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isPrivate=" + isPrivate +
                ", executionsInParallel=" + executionsInParallel +
                ", createdAt=" + createdAt +
                ", instructions=" + instructions.size() +
                '}';
    }
}
