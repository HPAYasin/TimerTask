import javax.swing.*;
import java.awt.*;

public class TimerGUI extends JFrame {
    private JTextArea logArea;
    private IntervalTimer intervalTimer;
    private ScheduledTimer scheduledTimer;
    private PeriodicTimer periodicTimer;

    public TimerGUI() {
        setTitle("Timer Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton intervalButton = new JButton("Start Interval Timer");
        JButton scheduledButton = new JButton("Start Scheduled Timer");
        JButton periodicButton = new JButton("Start Periodic Timer");
        JButton stopPeriodicButton = new JButton("Stop Periodic Timer");

        buttonPanel.add(intervalButton);
        buttonPanel.add(scheduledButton);
        buttonPanel.add(periodicButton);
        buttonPanel.add(stopPeriodicButton);
        add(buttonPanel, BorderLayout.SOUTH);

        intervalTimer = new IntervalTimer();
        scheduledTimer = new ScheduledTimer();
        periodicTimer = new PeriodicTimer();

        intervalButton.addActionListener(e -> intervalTimer.startTimer(() -> logMessage("Interval Timer Triggered!")));
        scheduledButton.addActionListener(e -> scheduledTimer.startTimer(() -> logMessage("Scheduled Timer Triggered!")));
        periodicButton.addActionListener(e -> periodicTimer.startTimer(() -> logMessage("Periodic Timer Triggered!")));
        stopPeriodicButton.addActionListener(e -> {
            periodicTimer.stopTimer();
            logMessage("Periodic Timer Stopped.");
        });
    }

    private void logMessage(String message) {
        SwingUtilities.invokeLater(() -> logArea.append(message + "\n"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimerGUI().setVisible(true));
    }
}
