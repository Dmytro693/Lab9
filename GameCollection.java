
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class GameCollection {

    private BoardGameSet[] games;

    // Ініціалізація масиву з 10 об'єктів
    public GameCollection() {
        games = new BoardGameSet[10];

        games[0] = new Chess("Шахи Classic", 1, 800, "дерев'яна");
        games[1] = new Monopoly("Монополія", 1, 1200, 6);
        games[2] = new Chess("Шахи Premium", 1, 2500, "магнітна");
        games[3] = new Monopoly("Монополія Junior", 1, 650, 4);
        games[4] = new Chess("Шахи Travel", 1, 500, "складна");
        games[5] = new Monopoly("Монополія Deluxe", 1, 1800, 6);
        games[6] = new Chess("Шахи Tournament", 1, 3200, "дерев'яна");
        games[7] = new Monopoly("Монополія City", 1, 950, 5);
        games[8] = new Chess("Шахи Mini", 1, 400, "пластикова");
        games[9] = new Monopoly("Монополія World", 1, 2200, 6);
    }

    // Виведення всіх елементів
    public void showAll() {
        for (int i = 0; i < games.length; i++) {
            System.out.println("\nІндекс: " + i);
            games[i].showInfo();
            System.out.println("------------------------");
        }
    }

    // Модифікація елемента
    public boolean modifyGame(int index, String name,
                             int numberOfGames, double price) {

        if (index < 0 || index >= games.length) {
            return false;
        }

        if (name == null || name.trim().isEmpty()
                || numberOfGames <= 0
                || !Double.isFinite(price)
                || price < 0) {
            return false;
        }

        games[index].setName(name);
        games[index].setNumberOfGames(numberOfGames);
        games[index].setPrice(price);

        return true;
    }

    // Пошук ігор дорожчих за задану ціну
    public void showGamesMoreExpensiveThan(double minPrice) {
        boolean found = false;

        for (BoardGameSet game : games) {
            if (game.getPrice() > minPrice) {
                game.showInfo();
                System.out.println("------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Ігор за цією умовою не знайдено.");
        }
    }

    // Сортування за ціною за зростанням
    public void sortAscending() {
        Arrays.sort(games,
                Comparator.comparingDouble(BoardGameSet::getPrice));
    }

    // Сортування за ціною за спаданням
    public void sortDescending() {
        Arrays.sort(games,
                Comparator.comparingDouble(BoardGameSet::getPrice).reversed());
    }

    // Сортування за назвою за зростанням
    public void sortByNameAscending() {
        Arrays.sort(games,
                Comparator.comparing(
                        BoardGameSet::getName,
                        String.CASE_INSENSITIVE_ORDER
                ));
    }

    // Сортування за назвою за спаданням
    public void sortByNameDescending() {
        Arrays.sort(games,
                Comparator.comparing(
                        BoardGameSet::getName,
                        String.CASE_INSENSITIVE_ORDER
                ).reversed());
    }

    // Пошук за регулярним виразом
    public void showGamesByRegex(String regex) {
        Pattern pattern = Pattern.compile(
                regex,
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE
        );

        boolean found = false;

        for (BoardGameSet game : games) {
            if (pattern.matcher(game.getName()).matches()) {
                game.showInfo();
                System.out.println("------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Ігор за заданою умовою не знайдено.");
        }
    }

    // Найменша та найбільша ціна
    public void showMinMaxPrice() {
        if (games.length == 0) {
            System.out.println("Масив ігор порожній.");
            return;
        }

        BoardGameSet minGame = games[0];
        BoardGameSet maxGame = games[0];

        for (BoardGameSet game : games) {
            if (game.getPrice() < minGame.getPrice()) {
                minGame = game;
            }

            if (game.getPrice() > maxGame.getPrice()) {
                maxGame = game;
            }
        }

        System.out.printf(
                "Найменшу ціну %.2f грн має гра \"%s\".%n",
                minGame.getPrice(), minGame.getName()
        );

        System.out.printf(
                "Найбільшу ціну %.2f грн має гра \"%s\".%n",
                maxGame.getPrice(), maxGame.getName()
        );
    }

    public int getSize() {
        return games.length;
    }
}
