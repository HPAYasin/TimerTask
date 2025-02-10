import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.Date;

public class ScheduledTimer {
    private Timer timer;

    public ScheduledTimer() {
        timer = new Timer();
    }

    public void startTimer(Runnable callback) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10); // Запуск через 10 секунд
        Date timeToRun = calendar.getTime();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                callback.run();
            }
        }, timeToRun);
    }
}