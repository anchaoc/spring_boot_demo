package com.ac.quartz.config;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**调度任务类
 * @author anchao
 * @date 2019/12/15 15:59
 */
@Slf4j
public class TestTask1 extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext context) {

        log.info("TestTask1.executeInternal.执行具体定时任务.threadName={}",Thread.currentThread().getName());
        JobDetail jobDetail = context.getJobDetail();
        log.warn("-->TestTask1.executeInternal.jobName={},jobGroup={}",jobDetail.getKey().getName(),jobDetail.getKey().getGroup());
        log.warn("-->TestTask1.executeInternal.jobMap.value={}",jobDetail.getJobDataMap().get("data").toString());

    }

}
