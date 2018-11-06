import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {


    public static void main(String[] args) throws Exception {
        System.out.println("-------开始定时任务--------");
        timer1();
        timer2();
    }

    public static void timer1() throws Exception {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date startDate = sdf.parse("2016/10/20 13:36:00");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------定时任务1--------" + sdf.format(this.scheduledExecutionTime()));
            }
        }, startDate, 5 * 1000);
    }


    public static void timer2() throws Exception {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date startDate = sdf.parse("2016/10/20 13:36:00");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------定时任务2--------" + sdf.format(this.scheduledExecutionTime()));
            }
        }, startDate, 5 * 1000);
    }

}
