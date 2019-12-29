package com.ac;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author anchao
 * @date 2019/12/29 16:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@Slf4j
public class ThreadPoolTest {
    //
//    @Resource
//    ThreadPoolTaskExecutor threadPoolTaskExecutor;
//
//    @Test
//    public void testExecute() throws ExecutionException, InterruptedException {
//
//        //异步执行无返回值
//        threadPoolTaskExecutor.execute(()->{
//            log.info("SpringBootDemoTest,testExecute,threadName={}",Thread.currentThread().getName());
//        });
//
//        //异步执行有返回值
//        Future<String> submit = threadPoolTaskExecutor.submit(() -> {
//            log.info("SpringBootDemoTest,testExecute,submit={}", Thread.currentThread().getName());
//            return Thread.currentThread().getName();
//        });
//
//        log.info("SpringBootDemoTest,testExecute,Future={}", submit.get());
//
//        this.testAsync();
//    }
//
//
//    @Async(value = "threadPoolTaskExecutor")
//    public void testAsync() {
//
//        log.info("SpringBootDemoTest,testAsync,threadName={}", Thread.currentThread().getName());
//
//    }
//
}
