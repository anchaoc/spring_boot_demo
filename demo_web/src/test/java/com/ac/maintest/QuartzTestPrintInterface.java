//package com.ac;
//
//
//import com.ac.quartz.task.JobInterface;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author anchao
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = WebApplication.class)
//@Slf4j
//public class QuartzTestPrintInterface {
//
//    @Autowired
//    private JobInterface jobInterface;
//
//    @Test
//    public void testAddScheduler(){
//
//        String jobName="jobName1";
//        String jobGroupName="jobGroupName1";
//        String triggerName="triggerName1";
//        String triggerGroupName="triggerGroupName1";
//        Class TestTask1 = com.ac.quartz.config.TestTask1.class;
//        String cron ="0/6 * * * * ?";
//        String arr = "test";
//        String str = jobInterface.addJob(jobName, jobGroupName, triggerName, triggerGroupName, TestTask1, cron, arr);
//        log.warn("QuartzTest.testAddScheduler,date={}",str);
//
//        try {
//            //服务运行延迟50S
//            Thread.sleep(50000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    @Test
//    public void testQueryAllScheduler(){
//
//        String str = jobInterface.queryAllJob();
//
//        log.warn("QuartzTest.testQueryAllScheduler.groups={}",str);
//    }
//
//}
