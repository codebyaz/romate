package com.codebyaz.romate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
public class RtaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RtaApplication.class, args);
	}

//	@Bean
//	public Executor taskExecutor() {
//		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//		executor.setCorePoolSize(3);
//		executor.setMaxPoolSize(3);
//		executor.setQueueCapacity(500);
//		executor.setThreadNamePrefix("run-");
//		executor.initialize();
//		return executor;
//	}
}