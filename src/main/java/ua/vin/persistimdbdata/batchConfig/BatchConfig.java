package ua.vin.persistimdbdata.batchConfig;


import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vin.persistimdbdata.model.OmdbUnit;
import ua.vin.persistimdbdata.step.OmdbReader;
import ua.vin.persistimdbdata.step.OmdbWriter;

@Configuration
public class BatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public OmdbReader reader(){
        return  new OmdbReader();
    }

    @Bean
    public OmdbWriter writer(){
        return new OmdbWriter();
    }



    @Bean
    public Job job() {
        return jobBuilderFactory.get("gansJob")
                .incrementer(new RunIdIncrementer())
                .start(step())
                .build();
    }
    @Bean
    public Step step() {
        return stepBuilderFactory.get("gansStep")
                .<OmdbUnit, OmdbUnit>chunk(1)
                .reader(reader())
                .writer(writer()    )
                .build();

    }



}
