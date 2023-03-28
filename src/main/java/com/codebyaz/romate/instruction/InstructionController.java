package com.codebyaz.romate.instruction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/instruction")
public class InstructionController {

    private final InstructionService instructionService;

    @Autowired
    InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    @PostMapping
    void saveInstruction(@RequestBody List<Instruction> instructions) {
        this.instructionService.save(instructions);
    }

}
