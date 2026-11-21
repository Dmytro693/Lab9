
public class Monopoly extends BoardGameSet {

    private int numberOfPlayers;

    public Monopoly(String name, int numberOfGames,
                   double price, int numberOfPlayers) {
        super(name, numberOfGames, price);
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public void play() {
        System.out.println("Граємо в Монополію.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Кількість гравців: " + numberOfPlayers);
    }
}
