import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTimerTask(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(new Date() + "name = " + name);
    }
}
