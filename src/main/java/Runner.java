public class Runner {
    public static void main(String[] args) {
        PlayerHuman player1 = new PlayerHuman();
        player1.setName("Gracz 1");

        PlayerHuman player2 = new PlayerHuman();
        player2.setName("Gracz 2");

        Board board = new Board();
        GameLogic gameLogic = new GameLogic(player1, player2, board);

        board.displayBoard(); // <-- tu chyba nie działa

        gameLogic.startGame();
    }
}
