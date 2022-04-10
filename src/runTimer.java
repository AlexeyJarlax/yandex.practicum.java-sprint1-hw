import java.util.*;

public class runTimer {
    public static void runTimerRun() {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println(".");
            }
        };

        for (int i = 3; i > 0; --i) {
            System.out.println("Возврат в меню через: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
            }
        }


    }
}