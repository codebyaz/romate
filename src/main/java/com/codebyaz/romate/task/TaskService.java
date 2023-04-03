package com.codebyaz.romate.task;

import com.codebyaz.romate.bot.Bot;
import com.codebyaz.romate.instruction.InstructionRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.inject.Provider;

@Service
@EnableAsync
public class TaskService {

    private final Provider<Bot> botProvider;

    public TaskService(
            Provider<Bot> botProvider
    ) {
        this.botProvider = botProvider;
    }

//    @Async
    public void run(Task task) {
        Bot bot = botProvider.get();
        bot.execute(task);
    }
}
