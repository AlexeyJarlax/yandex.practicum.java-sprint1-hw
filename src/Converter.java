import java.util.Scanner;

public class Converter {

    public void kilometer(int thisMonthAllSteps) {
        System.out.println("Пройденная дистанция в км. составляет: " + (thisMonthAllSteps * 0.00075));
    }

    public void kilocalories(int thisMonthAllSteps) {
        System.out.println("Количество сожжённых килокалорий составляет: " + (thisMonthAllSteps * 0.05));
        runTimer.runTimerRun();
    }

}