package com.insurgency.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 根据系统配置来配置一个线程池，是单例的，整个app生命周期只有一个
 *
 * @author Lynx
 * @since 2019/06/24
 */
@Configuration
@EnableAsync
@SuppressWarnings("unused")
public class AsyncConfig implements AsyncConfigurer {

    /**
     * logger 打印日志 output log
     */
    private static final Logger logger = LoggerFactory.getLogger(AsyncConfig.class);

    /**
     * 服务器的cpu个数
     */
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    /**
     * 核心线程数 根据cpu的个数啦动态配置最大的核心线程数 最优的最大核心线程数的公式为 cpu_count+1 CPU核数/（1-阻系数） 阻塞系数在0.8~0.9之间
     */
    private static final int CORE_POOL_SIZE = (int)(CPU_COUNT / (1 - 0.8)) + 1;

    /**
     * 最大线程数 根据cup的个数来动态配置最大的线程数 最优的最大线程数的公式为 cpu_count*2+1
     */
    private static final int MAX_POOL_SIZE = CORE_POOL_SIZE * 2 + 1;

    /**
     * 非核心线程数闲置的时间，超过该时间该线程将会被回收 TimeUnit:SECONDS
     *
     * @see java.util.concurrent.TimeUnit
     */
    private static final int KEEP_ALIVE_TIME = 2;

    /**
     * 当线程池内线程内全部繁忙时，处于等待队列的容量
     */
    private static final int BLOCKING_QUEUE_CAPACITY = 10000;

    @Override
    @Bean(value = "asyncExecutor")
    public Executor getAsyncExecutor() {
        logger.info("/***********************正在初始化线程池****************************");
        logger.info("*********               服务器CPU核数[{}]                  ********", CPU_COUNT);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        logger.info("*********               设定核心线程数:[{}]                 ********", CORE_POOL_SIZE);
        executor.setCorePoolSize(CORE_POOL_SIZE);
        logger.info("*********               设定线程空闲时存活时间 :[{}]         ********", KEEP_ALIVE_TIME);
        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        logger.info("*********               设定最大线程数 :[{}]                *********", MAX_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        logger.info("*********               设定等待队列的大小 :[{}]             *********", BLOCKING_QUEUE_CAPACITY);
        // 守护线程
        executor.setDaemon(true);
        executor.setQueueCapacity(BLOCKING_QUEUE_CAPACITY);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-thread-");
        // rejection-policy：当pool和等待池已经达到max size的时候，如何处理这时想添加进来的新任务
        // 使用拒绝执行策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 超时强行销毁
        executor.setAwaitTerminationSeconds(5 * 60);
        // 初始化执行器
        executor.initialize();
        logger.info("*********               线程池初始化完成!               *********/");
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}