import java.util.Timer;
import java.util.TimerTask;

public class PeriodicTimer {
    private Timer timer;

    public PeriodicTimer() {
        timer = new Timer();
    }

    public void startTimer(Runnable callback) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                callback.run();
            }
        }, 0, 5000);
    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
