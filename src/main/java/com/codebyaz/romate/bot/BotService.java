package com.codebyaz.romate.bot;

import com.codebyaz.romate.instruction.Instruction;
import com.codebyaz.romate.instruction.InstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.util.List;

@Service
public class BotService {
    private final InstructionRepository instructionRepository;

    private final Provider<Bot> botProvider;

    @Autowired
    public BotService(InstructionRepository instructionRepository, Provider<Bot> botProvider) {
        this.instructionRepository = instructionRepository;
        this.botProvider = botProvider;
    }

    @Async
    public void executeProcess(Long id) {
        List<Instruction> instructions = instructionRepository.findAllByProcessIdOrderBySequence(id);

        Bot bot = botProvider.get();

        bot.setInstructions(instructions);
        bot.executeInstructions();
    }
}
