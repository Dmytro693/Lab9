
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameCollection collection = new GameCollection();

        boolean running = true;

        while (running) {
            System.out.println("\n===== НАБІР НАСТІЛЬНИХ ІГОР =====");
            System.out.println("1. Вивести всі ігри");
            System.out.println("2. Змінити елемент масиву");
            System.out.println("3. Показати ігри дорожчі за задану ціну");
            System.out.println("4. Сортувати за зростанням ціни");
            System.out.println("5. Сортувати за спаданням ціни");
            System.out.println("6. Сортувати назви за зростанням");
            System.out.println("7. Сортувати назви за спаданням");
            System.out.println("8. Пошук назв, що закінчуються на «ія»");
            System.out.println("9. Показати найменшу та найбільшу ціну");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        collection.showAll();
                        break;

                    case 2:
                        System.out.print("Введіть індекс (0-9): ");
                        int index = Integer.parseInt(scanner.nextLine());

                        System.out.print("Нова назва: ");
                        String name = scanner.nextLine();

                        System.out.print("Кількість ігор: ");
                        int count = Integer.parseInt(scanner.nextLine());

                        System.out.print("Нова ціна: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        if (collection.modifyGame(index, name, count, price)) {
                            System.out.println("Елемент успішно змінено.");
                        } else {
                            System.out.println("Некоректний індекс або дані.");
                        }
                        break;

                    case 3:
                        System.out.print("Введіть мінімальну ціну: ");
                        double minPrice = Double.parseDouble(scanner.nextLine());

                        if (!Double.isFinite(minPrice)) {
                            System.out.println("Ціна має бути скінченним числом.");
                            break;
                        }

                        collection.showGamesMoreExpensiveThan(minPrice);
                        break;

                    case 4:
                        collection.sortAscending();
                        System.out.println("Відсортовано за зростанням ціни.");
                        collection.showAll();
                        break;

                    case 5:
                        collection.sortDescending();
                        System.out.println("Відсортовано за спаданням ціни.");
                        collection.showAll();
                        break;

                    case 6:
                        collection.sortByNameAscending();
                        System.out.println("Відсортовано за назвою за зростанням.");
                        collection.showAll();
                        break;

                    case 7:
                        collection.sortByNameDescending();
                        System.out.println("Відсортовано за назвою за спаданням.");
                        collection.showAll();
                        break;

                    case 8:
                        // Назва закінчується на «ія»
                        collection.showGamesByRegex(".*ія$");
                        break;

                    case 9:
                        collection.showMinMaxPrice();
                        break;

                    case 0:
                        running = false;
                        System.out.println("Програму завершено.");
                        break;

                    default:
                        System.out.println("Невірний пункт меню.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Помилка: введіть коректне числове значення."
                );
            }
        }

        scanner.close();
    }
}
