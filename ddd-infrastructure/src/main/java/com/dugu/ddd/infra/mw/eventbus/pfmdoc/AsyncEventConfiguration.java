package com.dugu.ddd.infra.mw.eventbus.pfmdoc;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author cihun
 * @date 2023-09-22 17:53
 */
@Configuration
@EnableAsync
public class AsyncEventConfiguration implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        return Executors.newFixedThreadPool(10);
    }
}