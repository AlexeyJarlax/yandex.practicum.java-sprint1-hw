import java.util.*;
// мне не понравилось, что сразу после действия пользователя выводится окно с очередными действиями, когда пользователь еще не прочел результат прошлого действия, так что я решил добавить мини таймер к коду


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