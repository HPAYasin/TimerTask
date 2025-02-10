import java.util.Timer;
import java.util.TimerTask;

public class IntervalTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Сработал таймер через 3 секунды!");
            }
        };
        timer.schedule(task, 3000); // Запуск через 3 секунды
    }
}