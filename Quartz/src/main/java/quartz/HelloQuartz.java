package quartz;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import quartz.job.HelloJob;

import java.util.Calendar;

public class HelloQuartz {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("name1", "group1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("name1", "group1").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        System.out.println("任务开始: " + DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
