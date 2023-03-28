package com.codebyaz.romate.process;

import com.codebyaz.romate.instruction.Instruction;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Process {

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

    @Transient
    @OneToMany(mappedBy = "Instruction")
    List<Instruction> instructions;

    public Process() {}

    public Process(Long id) {
        this.id = id;
    }

    public Process(String name) {
        this.name = name;
    }
}
