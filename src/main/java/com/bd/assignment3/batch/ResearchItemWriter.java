package com.bd.assignment3.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JpaItemWriter;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ResearchItemWriter<T> extends JpaItemWriter<List<T>> {

    private final JpaItemWriter<T> jpaItemWriter;

    @Override
    @Transactional
    public void write(List<? extends List<T>> items) {
        
        List<T> collect = new ArrayList<>();
        
        for(List<T> list : items) {
            collect.addAll(list);
        }

        jpaItemWriter.write(collect);
        System.out.println("ResearchItemWriter.write");
    }

    @Override
    public void afterPropertiesSet() {

    }
}
