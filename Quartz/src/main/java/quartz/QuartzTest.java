package quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;


import quartz.job.HelloJob;

public class QuartzTest {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();

        // define the job and tie it to our HelloJob class
        JobDetail jobDetail = newJob(HelloJob.class).withIdentity("myJob", "group1").usingJobData("jobSays", "Hello World!").usingJobData("myFloatValue", 3.141f).build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(simpleSchedule().withIntervalInSeconds(1).repeatForever()).build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(jobDetail, trigger);

        Thread.sleep(10000);

        scheduler.shutdown();
    }
}