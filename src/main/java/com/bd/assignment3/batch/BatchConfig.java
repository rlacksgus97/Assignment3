package com.bd.assignment3.batch;

import com.bd.assignment3.research.Research;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

    static int page = 1;

    public final JobBuilderFactory jobBuilderFactory;
    public final StepBuilderFactory stepBuilderFactory;
    public final EntityManagerFactory entityManagerFactory;

    @Bean
    public ResearchItemReader reader() {
        return new ResearchItemReader(new ObjectMapper());
    }

    @Bean
    public ResearchItemProcessor processor() {
        return new ResearchItemProcessor();
    }

    @Bean
    public ResearchItemWriter<Research> writer() {
        JpaItemWriter<Research> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return new ResearchItemWriter<>(writer);
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .<ApiResDto, List<Research>>chunk(1)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job job(CustomJobListner customJobListner, Step step) {
        return jobBuilderFactory.get("job")
                .listener(customJobListner)
                .flow(step)
                .end()
                .build();
    }
}
