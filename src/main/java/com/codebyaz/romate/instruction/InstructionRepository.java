package com.codebyaz.romate.instruction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {
    List<Instruction> findAllByProcessIdOrderBySequence(Long id);
}
