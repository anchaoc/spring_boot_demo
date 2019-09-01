package com.ac.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author anchao
 */
@Slf4j
@Configuration
@EnableAsync
public class ExecutorConfig {

    @Value("${threadpool.core-pool-size}")
    private int corePoolSize;

    @Value("${threadpool.max-pool-size}")
    private int maxPoolSize;

    @Value("${threadpool.queue-capacity}")
    private int queueCapacity;

    @Value("${threadpool.keep-alive-seconds}")
    private int keepAliveSeconds;

    /**
     * 线程池配置
     */
    @Bean(name = "threadPoolTaskExecutor")
    public Executor getThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix("user-thread-");
        //队列满，线程被拒绝执行策略
        executor.setRejectedExecutionHandler(new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        log.warn("threadPoolTaskExecutor 初始化完成-->"+corePoolSize);
        return executor;
    }
}
