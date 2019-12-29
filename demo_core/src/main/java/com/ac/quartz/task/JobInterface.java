package com.ac.quartz.task;

import org.quartz.Job;

/**
 * @author anchao
 * @date 2019/12/29 16:01
 */
public interface JobInterface {

    String CRON_XING ="*";

    /**添加一个定时任务
     * @param jobName 任务名
     * @param jobGroupName 任务组名
     * @param triggerName 触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass 任务类名
     * @param cron 时间
     * @param data 参数
     */
    String addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName
            , Class<? extends Job> jobClass, String cron, String data);


    /**
     * 删除一个定时任务
     * @param jobName 任务名
     * @param jobGroupName 任务组名
     * @param triggerName 触发器名
     * @param triggerGroupName 触发器组名
     */
    String removeJob(String jobName,String jobGroupName,String triggerName,String triggerGroupName);


    /**修改一个任务
     * @param jobName 任务名
     * @param jobGroupName 任务组名
     * @param triggerName 触发器名
     * @param triggerGroupName 触发器组名
     * @param cron 时间
     * @param data 数据
     */
    String modifyJobTime(String jobName,String jobGroupName,String triggerName,String triggerGroupName
            ,String cron,String data);


    /**
     * 获取所有调度任务
     */
    String queryAllJob();



}
