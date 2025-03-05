import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Программа завершена");
                    return;
                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addDish(dishType,dishName);// добавьте новое блюдо
    }

    private static void generateDishCombo() {
        ArrayList<String> categories = new ArrayList<>();

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");

        int numberOfCombos = enterNumber();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = " ";

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            nextItem = scanner.nextLine();
            if(!dc.existCategory(nextItem) && !nextItem.isEmpty()) {
                System.out.println("Такой категории нет");
                return;
            }
            categories.add(nextItem);
        }
        categories.removeLast();
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо номер " + (i + 1));
            System.out.println(dc.generateRandomCombo(categories));
        }

        // сгенерируйте комбинации блюд и выведите на экран
    }
    public static int enterNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод!");
            scanner.next();
        }
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        return numberOfCombos;
    }
}
