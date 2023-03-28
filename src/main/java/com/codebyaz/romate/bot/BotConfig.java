package com.codebyaz.romate.bot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.inject.Provider;

@Configuration
public class BotConfig {
    @Bean
    @Scope("prototype")
    public Bot bot() {
        return new Bot();
    }

    @Bean
    public Provider<Bot> botProvider() {
        return new Provider<Bot>() {
            @Override
            public Bot get() {
                return bot();
            }
        };
    }
}
