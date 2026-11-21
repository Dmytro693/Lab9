
public class Chess extends BoardGameSet {

    private String boardType;

    public Chess(String name, int numberOfGames,
                 double price, String boardType) {
        super(name, numberOfGames, price);
        this.boardType = boardType;
    }

    public String getBoardType() {
        return boardType;
    }

    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    @Override
    public void play() {
        System.out.println("Граємо в шахи.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Тип шахівниці: " + boardType);
    }
}
