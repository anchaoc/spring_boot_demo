package com.ac.quartz.config;

import com.ac.quartz.task.TestTask1;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anchao
 * @date 2019/12/15 16:03
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail testQuartz1() {
        return JobBuilder.newJob(TestTask1.class).withIdentity("testTask1").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger1() {
        //1小时执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInHours(1)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(testQuartz1())
                .withIdentity("testTask1")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
