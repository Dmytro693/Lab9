
public abstract class BoardGameSet {

    protected String name;
    protected int numberOfGames;
    protected double price;

    public BoardGameSet(String name, int numberOfGames, double price) {
        this.name = name;
        this.numberOfGames = numberOfGames;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void showInfo() {
        System.out.println("Назва: " + name);
        System.out.println("Кількість ігор: " + numberOfGames);
        System.out.printf("Ціна: %.2f грн%n", price);
    }

    public abstract void play();
}
