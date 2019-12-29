package com.ac.quartz.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author anchao
 * @date 2019/12/15 16:03
 */
@Configuration
public class QuartzConfig {

//    @Bean
//    public JobDetail testQuartz1() {
//        return JobBuilder.newJob(TestTask1.class).withIdentity("job1", "group1").storeDurably().build();
//    }
//
//    @Bean
//    public Trigger testQuartzTrigger1() {
//        //简单定时 1小时执行一次
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInHours(1)
//                .repeatForever();
//        return TriggerBuilder.newTrigger().forJob(testQuartz1())
//                .withIdentity("testTask1")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
//
//    @Bean
//    public Trigger scheduleJob1(){
//        //cron 表达式 每6秒执行一次
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");
//        return TriggerBuilder.newTrigger().forJob(testQuartz1()).withIdentity("trigger1", "group1") .withSchedule(scheduleBuilder).build();
//    }

}
