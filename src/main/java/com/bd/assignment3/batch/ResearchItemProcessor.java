package com.bd.assignment3.batch;

import com.bd.assignment3.research.Research;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;

public class ResearchItemProcessor implements ItemProcessor<ApiResDto, List<Research>> {
    @Override
    public List<Research> process(ApiResDto item) throws Exception {
        System.out.println("ResearchItemProcessor.process");
        return item.getData();
    }
}
