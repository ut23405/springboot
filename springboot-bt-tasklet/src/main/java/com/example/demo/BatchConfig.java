package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	@Autowired private HelloFirst HelloFirst;
	@Autowired private HelloSecond HelloSecond;
	@Autowired private JobBuilderFactory jobBuilderFactory;
	@Autowired private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job TestJob1(Step TestStep1,Step TestStep2) {
        return jobBuilderFactory.get("testJob")
        		.incrementer(new RunIdIncrementer())
				.start(TestStep1)
				.next(TestStep2)
                .build();
    }

    @Bean
    public Step TestStep1() {
        return stepBuilderFactory.get("TestStep11")
                .tasklet(HelloFirst)
                .build();
    }
    @Bean
    public Step TestStep2() {
        return stepBuilderFactory.get("TestStep21")
                .tasklet(HelloSecond)
                .build();
    }
}
