import java.util.Scanner;

public class StepTracker {
    String error = "Ошибка мясного мешка, сброс в главное меню!"; // переменная для ответа на ошибочный ввод данных
    //int userInput;
    // int month = 0;
    // int day = 0;
    // int max = 0;
    // int shagomer = 0;
    int stepGoal = 10000;

    //int thisMonthAllSteps = 0; // шаги за весь месяц
    int[] stepOfEachDay = new int[360]; // массив для хранение данных о количестве пройденных шагов за всё время


    int dayMemory(Scanner scanner) { // Метод для регистрации шагов в массив
        System.out.println("За какой месяц вы хотите ввести шаги? (1 - январь; 2 - февраль; 3 - март и т.д.)");
        int month = scanner.nextInt();
        if (month < 0) {
            System.out.println("Отрицательное значение месяца недопустимо! АЗАЗАЗАЗЗА!!!!11111 " + error);
            return 0;
        } else if (month > 12) {
            System.out.println("В нашем календаре только 12 месяцев!!! Чтобы расширить функционал на 13+ переведите 0,01 bitcoin на кошелек автора. " + error);
            return 0;
        }
        System.out.println("Месяц записан. За какое число этого месяца вы хотите ввести данные?");
        int day = scanner.nextInt();
        if (day < 1) {
            System.out.println("значение дня недопустимо! " + error);
            return 0;
        } else if (day > 30) {
            System.out.println("значение дня превышает 30! Чтобы расширить функционал на 30+ переведите 0,02 bitcoin на кошелек автора, или найдите другой календарь!!! " + error);
            return 0;
        }
        System.out.println("День усвоен. Введите количество шагов");
        int stepsThisDay = scanner.nextInt();
        if (stepsThisDay < 0) {
            System.out.println(error);
            return 0;
        }
        stepOfEachDay[(month - 1) * 30 + (day - 1)] = stepOfEachDay[(month - 1) * 30 + (day - 1)] + stepsThisDay;
        System.out.println("Значение в " + stepOfEachDay[(month - 1) * 30 + (day - 1)] + " шагов, проделанных " + day + " дня " + month + " месяца сохранено в календарь!");
        if ((stepOfEachDay[(month - 1) * 30 + (day - 1)]) >= stepGoal) {
            System.out.println("Цель в этот день выполнена! Возьми с полки пирожок");
        } else {
            System.out.println("Цель в этот день все еще не выполнена!");
        }

        runTimer.runTimerRun();
        return stepOfEachDay[(month - 1) * 30 + (day - 1)];
    }

    public int showMeEveryDay(Scanner scanner) { // метод для вывода шагов за каждый день месяца и подсчета серий

        // переменные для новой серии и самой большой серии, Начало, Объем и Количество:
        int newSeriesBegin = 0; // первый день серии
        int newSeriesVolume = 0; // объем серии
        int newSeriesQuantity = 0; // количество циклов серии
        int biggestSeriesBegin = 0;
        int biggestSeriesVolume = 0;
        int biggestSeriesQuantity = 0;

        System.out.println("За какой месяц вы хотите получить данные? (1 - январь; 2 - февраль; 3 - март и т.д.)");
        int month = scanner.nextInt();
        if (month > 12) {
            System.out.println(error);

        } else if (month < 1) {
            System.out.println(error);

        } else {
            System.out.println("Количество пройденных шагов по дням:");
            for (int i = 0; i < 30; i++) {
                System.out.print("Значение шагов в " + (i + 1) + " день составляет " + stepOfEachDay[i + (month - 1) * 30]);
                if (stepOfEachDay[i + (month - 1) * 30] >= stepGoal) {

                    System.out.println(". Цель достигнута!!! ");

                    // СЕРИАЛ АКТ 1. ИТЕРАЦИЯ 1. ПРОВЕРКА ПЕРВАЯ ЛИ ЭТО ПОБЕДНАЯ ПОПЫТКА В НОВОЙ СЕРИИ
                    if (newSeriesQuantity == 0) {
                        newSeriesBegin = i;
                        newSeriesVolume = stepOfEachDay[i + (month - 1) * 30];
                        newSeriesQuantity = 1;

                        // ИТЕРАЦИЯ 2. ПОПЫТКА НЕ ПЕРВАЯ newSeriesBegin - начало не трогаем, ему уже присвоено какое то значение i прошлого круга
                    } else {
                        newSeriesVolume = newSeriesVolume + stepOfEachDay[i + (month - 1) * 30];
                        newSeriesQuantity = newSeriesQuantity + 1;

                        // ИТЕРАЦИЯ 3. ПРИСВОЕНИЕ СТАРОЙ СЕРИИ ПОКАЗАТЕЛЕЙ НОВОЙ БОЛЕЕ ДЛИННОЙ СЕРИИ.
                        if (newSeriesQuantity > biggestSeriesQuantity) {
                            biggestSeriesBegin = newSeriesBegin;
                            biggestSeriesVolume = newSeriesVolume;
                            biggestSeriesQuantity = newSeriesQuantity;

                            // ИТЕРАЦИЯ 4. ПРИСВОЕНИЕ СТАРОЙ СЕРИИ ПОКАЗАТЕЛЕЙ НОВОЙ СЕРИИ, ЕСЛИ В НЕЙ БОЛЬШЕ ШАГОВ.
                        } else if (newSeriesQuantity == biggestSeriesQuantity) {
                            if (newSeriesVolume > biggestSeriesVolume) {
                                biggestSeriesBegin = newSeriesBegin;
                                biggestSeriesVolume = newSeriesVolume;
                                biggestSeriesQuantity = newSeriesQuantity;
                            }
                        }
                    }
                } else {
                    System.out.println(". Цель не достигнута ¯\\_(ツ)_/¯ ");

                    // СЕРИАЛ АКТ 2. ОБНУЛЕНИЕ ДАННЫХ НОВОЙ ПРЕРВАННОЙ СЕРИИ ПРИ ЛЮБЫХ ВАРИАНТАХ.
                    newSeriesBegin = 0; // первый день серии
                    newSeriesVolume = 0; // объем серии
                    newSeriesQuantity = 0; // количество циклов серии
                } // НОВЫЙ ДЕНЬ В КАРМАНЕ ДОЛЛАР
            }
        }
        // ОБЪЯВЛЕНИЕ ИТОГОВ СЕРИАЛА:
        if (biggestSeriesQuantity > 1) {
        System.out.println("Максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого началось " + biggestSeriesBegin + " числа месяца. Серия продлилась " + biggestSeriesQuantity + " дня и составила в сумме " + biggestSeriesVolume + " шагов!");
        } else {
        System.out.println("Вы не смогли сохранить ритм более одного дня ¯\\_(ツ)_/¯. Данные о серии шагов не зачтены.");
        }
        return month;

    }

    public int statistaylo(int month) { // метод для подсчета и вывода статистики за весь месяц

        int thisMonthAllSteps = 0; // общее количество шагов за исследуемый месяц
        for (int i = 0; i < 30; i++) { // далее выводим сумму шагов месяца
            thisMonthAllSteps = thisMonthAllSteps + stepOfEachDay[i + (month - 1) * 30];
        }
        System.out.println("Количество шагов за весь месяц составляет " + thisMonthAllSteps);

        int maxDaySteps = 0; // далее выводим max шагов месяца
        for (int i = 0; i < 30; i++) {
            if ((stepOfEachDay[i + (month - 1) * 30]) > maxDaySteps) { // Сравниваем
                maxDaySteps = stepOfEachDay[i + (month - 1) * 30];
            }
        }
        System.out.println("Максимальное количество шагов в одном дне месяца составляет: " + maxDaySteps);

        System.out.println("Среднее количество шагов в месяц составляет: " + (thisMonthAllSteps / 30)); // среднее арифметическое

        return thisMonthAllSteps; // возвращаю в мейн все шаги месяца, чтобы от туда мог забрать конвертер и обсчитать конвертацию в км и ккл....

    }

    public void newGoal(Scanner scanner) {
        // метод для перемены цели
        int userInput;
        System.out.println("Какой цели я служу?");
        userInput = scanner.nextInt(); // принимаем данные во временное хранилище
        if (userInput < 0) {
            System.out.println(" У самурая нет цели! " + error);
        } else {
            stepGoal = userInput; // если данные допустимы, присваиваем переменной значение из хранилища
            System.out.println("Цель изменена на " + stepGoal);
        }
        runTimer.runTimerRun();
    }

}