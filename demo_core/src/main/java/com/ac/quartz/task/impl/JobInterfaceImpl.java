package com.ac.quartz.task.impl;

import com.ac.quartz.task.JobInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author anchao
 * @date 2019/12/29 16:04
 */
@Slf4j
@Service
public class JobInterfaceImpl implements JobInterface {

    /**
     *
     * Scheduler调度器
     * 操作定时任务
     */
    @Autowired
    private Scheduler scheduler;





    @Override
    public String addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName
            , Class<? extends Job> jobClass, String cron, String data) {

        //触发器
        Trigger trigger;

        try {

            //构建jobDetail实例，绑定任务执行类
            JobDetail job = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            // 参数传递到任务类中(必须是String类型的参数)
            job.getJobDataMap().put("data", data);
            //如果包含 * 则执行 cron表达式
            if (cron.contains(CRON_XING)) {
                //cron表达式执行任务
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(triggerName, triggerGroupName)
                        .startNow()
                        .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                        .build();
            } else {
                //简单定时 按每cron小时执行任务
                SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInHours(Integer.valueOf(cron))
                        .repeatForever();
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(triggerName, triggerGroupName)
                        .withSchedule(simpleScheduleBuilder)
                        .build();
            }
            // 把任务和触发器
            // 注册到调度器中
            Date date = scheduler.scheduleJob(job, trigger);
            log.info("JobInterfaceImpl.addJob.date={}", date.toString());
            this.startScheduler();
            return StringUtils.join(",",jobName,jobGroupName,triggerName,triggerGroupName);
        } catch (SchedulerException e) {
            log.error("obInterfaceImpl.addJob.error", e);
            return StringUtils.EMPTY;
        }

    }



    @Override
    public String removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {

        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            //停止触发
            scheduler.pauseTrigger(triggerKey);
            //移除触发
            scheduler.unscheduleJob(triggerKey);
            //删除任务
            scheduler.deleteJob(JobKey.jobKey(jobName,jobGroupName));

            return StringUtils.join(",",jobName,jobGroupName,triggerName,triggerGroupName);

        } catch (SchedulerException e) {
            log.error("JobInterfaceImpl.removeJob.error",e);
            return StringUtils.EMPTY;
        }
    }



    @Override
    public String modifyJobTime(String jobName, String jobGroupName, String triggerName, String triggerGroupName, String cron, String data) {
        try {
            //根据触发器名和触发器组名获取到旧触发器的键从而获取到触发器
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return StringUtils.EMPTY;
            }
            //通过CronTrigger获取以前设定的时间
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {
                //方式一：通过rescheduleJob替换旧的触发器
//				TriggerBuilder<Trigger> newTrigger = TriggerBuilder.newTrigger();
//				newTrigger.withIdentity(jobName,jobGroupName);
//				newTrigger.startNow();
//				newTrigger.withSchedule(CronScheduleBuilder.cronSchedule(cron));
//				CronTrigger cronTrigger = (CronTrigger)newTrigger.build();
//				scheduler.rescheduleJob(triggerKey, cronTrigger); //替换以前旧的触发器
                //方式二：先删除，然后在创建一个新的Job
                JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                Class<? extends Job> jobClass = jobDetail.getJobClass();
                this.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
                addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron, data);
            }
            return StringUtils.join(",",jobName,jobGroupName,triggerName,triggerGroupName);
        } catch (SchedulerException e) {
            log.error("JobInterfaceImpl.modifyJobTime.error",e);
            return StringUtils.EMPTY;
        }

    }



    @Override
    public String queryAllJob() {
        try {
            // 获取调度器中所有的触发器组集合
            List<String> triggerGroups = scheduler.getTriggerGroupNames();

            if(CollectionUtils.isEmpty(triggerGroups)){
                return StringUtils.EMPTY;
            }

            return triggerGroups.toString();

        } catch (Exception e) {
            log.error("JobInterfaceImpl.queryAllJob.error", e);
            return StringUtils.EMPTY;
        }
    }












    /**
     * 启动触发器
     */
    private void startScheduler() {
        try {
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (SchedulerException e) {
            log.error("JobInterfaceImpl.startScheduler.error", e);
        }
    }

    /**
     * 关闭触发器
     */
    private void stopScheduler() {
        try {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (SchedulerException e) {
            log.error("JobInterfaceImpl.stopScheduler.error", e);
        }
    }


}
