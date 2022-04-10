import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        StepTracker StepTracker = new StepTracker(); // ОБЪЯВЛЯЕМ КЛАСС СТЕПТРЕКЕР

        runTimer runTimer = new runTimer(); // ОБЪЯВЛЯЕМ КЛАСС РАНТАЙМЕР (ДЛЯ ЗАМЕДЛЕНИЯ ВОЗВРАТА В ГЛАВНОЕ МЕНЮ)

        Converter Converter = new Converter(); // ОБЪЯВЛЯЕМ КЛАСС КОНВЕРТЕР

                Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {

            if (userInput == 1) { // Ввести количество шагов за определённый день
                StepTracker.dayMemory(scanner);
                // тут закончили c Input == 1

            } else if (userInput == 2) { // Ввести статистику за определённый месяц
                int month = StepTracker.showMeEveryDay(scanner);
                int thisMonthAllSteps = StepTracker.statistaylo(month);
                Converter.kilometer(thisMonthAllSteps);
                Converter.kilocalories(thisMonthAllSteps);
                // тут закончили c Input == 2

            } else if (userInput == 3) { // Изменить цель по количеству шагов в день
                StepTracker.newGoal(scanner);
                // тут закончили c Input == 3
            }
            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя

        }
        System.out.println("Программа завершена");

    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }


}

