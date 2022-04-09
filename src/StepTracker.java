import java.util.Scanner;

public class StepTracker {
    String error = "Ошибка мясного мешка, сброс в главное меню!"; // переменная для ответа на ошибочный ввод данных
    int userInput;
    int month = 0;
    int day = 0;
    int max = 0;
    int shagomer = 0;
    int stepGoal = 10000;
    int allMonthSteps = 0; // шаги за весь месяц
    int[] stepOfEachDay = new int[360]; // массив для хранение данных о количестве пройденных шагов за всё время


        int dayMemory(Scanner scanner) { // Метод для регистрации шагов в массив
            System.out.println("За какой месяц вы хотите ввести шаги? (1 - январь; 2 - февраль; 3 - март и т.д.)");
            month = scanner.nextInt();
                if (month < 0) {
                    System.out.println("Отрицательное значение месяца недопустимо! АЗАЗАЗАЗЗА!!!!11111 " + error);
                    return 0;
                } else if (month > 12) {
                    System.out.println("В нашем календаре только 12 месяцев!!! Чтобы расширить функционал на 13+ переведите 0,01 bitcoin на кошелек автора. " + error);
                    return 0;
                }
                    System.out.println("Месяц записан. За какое число этого месяца вы хотите ввести данные?");
                    day = scanner.nextInt();
                if (day < 1) {
                    System.out.println("значение дня недопустимо! " + error);
                    return 0;
                } else if (day > 30) {
                    System.out.println("значение дня превышает 30! Чтобы расширить функционал на 30+ переведите 0,02 bitcoin на кошелек автора, или найдите другой календарь!!! " + error);
                    return 0;
                }
                    System.out.println("День усвоен. Введите количество шагов");
                    shagomer = scanner.nextInt();
                if (shagomer < 0) {
                    System.out.println(error);
                    return 0;
                }
                    stepOfEachDay[(month-1)*30+(day-1)] = stepOfEachDay[(month-1)*30+(day-1)] + shagomer;
                    System.out.println("Значение в " + stepOfEachDay[(month-1)*30+(day-1)] + " шагов, проделанных " + day + " дня " + month + " месяца сохранено в календарь!");
                if (shagomer >= stepGoal) {
                 System.out.println("Цель в этот день выполнена! Возьми с полки пирожок");
                } else {
                 System.out.println("Цель в этот день не выполнена! Плохо стараешься, жирная свинина");
                }

                runTimer.runTimerRun();
                return stepOfEachDay[(month-1)*30+(day-1)];
                }

        public void Statistaylo(Scanner scanner) { // метод для подсчета и вывода статистики
            System.out.println("За какой месяц вы хотите получить данные? (1 - январь; 2 - февраль; 3 - март и т.д.)");
            month = scanner.nextInt();
            if (month > 12) {
                System.out.println(error);

            } else if (month < 1) {
                System.out.println(error);

            } else {
                System.out.println("Количество пройденных шагов по дням:");
                for (int i = 0; i < 30; i++) {
                    System.out.print("Значение шагов в " + (i+1) + " день составляет " + stepOfEachDay[i+(month-1)*30]);
                    if (stepOfEachDay[i+(month-1)*30] < stepGoal) {
                    System.out.println(". Цель не достигнута ¯\\_(ツ)_/¯ ");
                    } else {
                    System.out.println(". Цель достигнута!!! ");
                    }
                }
                for (int i = 0; i < 30; i++) { // далее выводим сумму шагов месяца
                    allMonthSteps = allMonthSteps + stepOfEachDay[i+(month-1)*30];
                }
                    System.out.println("Количество шагов за весь месяц составляет " + allMonthSteps);
                for (int i = 0; i < 30; i++) { // далее выводим max шагов месяца
                    if ((stepOfEachDay[i+(month-1)*30]) > max) { // Сравниваем
                        max = stepOfEachDay[i+(month-1)*30];
                    }
                }
                System.out.println("Максимальное количество шагов в одном дне месяца составляет: " + max);

                System.out.println("Среднее количество шагов в месяц составляет: " + (allMonthSteps/30)); // далее выводим среднее арифметические

                System.out.println("Пройденная дистанция в км. составляет: " + (allMonthSteps * 0.00075));

                System.out.println("Количество сожжённых килокалорий составляет: " + (allMonthSteps * 0.05));
            }
                runTimer.runTimerRun();



        }
        public void newGoal(Scanner scanner) { // метод для перемены цели
            System.out.println("Какой цели я служу?");
            userInput = scanner.nextInt(); // принимаем данные во временное хранилище
            if (userInput < 0) {
                System.out.println(" Цель не может быть отрицательной! " + error);
            } else {
            stepGoal = userInput; // если данные допустимы, присваиваем переменной значение из хранилища
            System.out.println("Цель изменена на " + stepGoal);
            }
            runTimer.runTimerRun();
        }
}

