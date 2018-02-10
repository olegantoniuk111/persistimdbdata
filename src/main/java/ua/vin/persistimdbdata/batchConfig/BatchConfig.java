package ua.vin.persistimdbdata.batchConfig;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.task.TaskExecutor;
import ua.vin.persistimdbdata.model.OmdbUnit;
import ua.vin.persistimdbdata.step.OmdbRestReader;
import ua.vin.persistimdbdata.step.Processor;
import ua.vin.persistimdbdata.step.Writer;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class BatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job job() {
        return jobBuilderFactory.get("gansJob")
                .start(step()).build();
    }
    @Bean
    public Step step() {
        return stepBuilderFactory.get("gansStep")
                .<List<String>, List<OmdbUnit>>chunk(0)
                .reader(new OmdbRestReader())
                .writer(new Writer())
                .processor(new Processor()).build();

    }



}
