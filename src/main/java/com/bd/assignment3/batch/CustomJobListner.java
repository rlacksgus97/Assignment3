package com.bd.assignment3.batch;

import org.springframework.batch.core.*;
import org.springframework.stereotype.Component;

@Component
public class CustomJobListner implements JobExecutionListener {


    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }
}
