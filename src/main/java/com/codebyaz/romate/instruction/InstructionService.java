package com.codebyaz.romate.instruction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructionService {

    private final InstructionRepository instructionRepository;

    @Autowired
    public InstructionService(InstructionRepository instructionRepository){
        this.instructionRepository = instructionRepository;
    }
    public void save(List<Instruction> instructions) {
        this.instructionRepository.saveAll(instructions);
    }
}
