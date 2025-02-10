import java.util.Timer;
import java.util.TimerTask;

public class IntervalTimer {
    private Timer timer;

    public IntervalTimer() {
        timer = new Timer();
    }

    public void startTimer(Runnable callback) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                callback.run();
            }
        }, 3000);
    }
}