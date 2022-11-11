import java.util.Scanner;

public class Main {
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
    public static int taxEarnings(int earnings) {
        int tax = (earnings) * 6 / 100;
        return tax;
    }
    public static void main(String[] args) {
        //Создаем scanner - объект, который будет считывать из стандартного потока ввода/вывода (console)
        Scanner scanner = new Scanner(System.in);

//Цикл будет работать, пока пользователь не введет `end`
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы
        while (true) {
            String input;
            System.out.println("");
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");
            // Выводим информацию о возможных операциях пользователю
            input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        String moneyStr = scanner.nextLine();
                        int money = Integer.parseInt(moneyStr);
                        earnings += money;
                        break;
                    case 2:
                        // действия при выборе второй операции
                        System.out.println("Введите сумму расхода:");
                        moneyStr = scanner.nextLine();
                        money = Integer.parseInt(moneyStr);
                        spendings += money;
                        break;
                    case 3:
                        if (taxEarningsMinusSpendings (earnings, spendings) < taxEarnings (earnings)) {
                            System.out.println("Мы советуем вам УСН доходы минус расходы");
                            System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings (earnings, spendings) + " руб.");
                            System.out.println("Налог на другой сисетме: " + taxEarnings (earnings) + " руб.");
                            System.out.println("Экономия: " + (taxEarnings (earnings) - taxEarningsMinusSpendings (earnings, spendings))  + " руб.");
                        }
                        else if (taxEarningsMinusSpendings (earnings, spendings) > taxEarnings (earnings)) {
                            System.out.println("Мы советуем вам УСН доходы");
                            System.out.println("Ваш налог составит: " + taxEarnings (earnings) + " руб.");
                            System.out.println("Налог на другой системе: " + taxEarningsMinusSpendings (earnings, spendings) + " руб.");
                            System.out.println("Экономия: " + (taxEarningsMinusSpendings (earnings, spendings) - taxEarnings (earnings))  + " руб.");
                        }
                        else {
                            System.out.println("Вы можете выбрать любую систему");
                            System.out.println("Ваш налог составит: " + taxEarnings (earnings) + " руб.");
                        }
                        break;
                    default:
                        System.out.println("Такой операции нет");

                }

            }
        }
        System.out.println("Программа завершена!");
    }

}