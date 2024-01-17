public class Runner {
    public static void main(String[] args) {
        PlayerComputer player1 = new PlayerComputer();
        player1.setName("Gracz 1");

        PlayerComputer player2 = new PlayerComputer();
        player2.setName("Gracz 2");

        Board board = new Board();
        GameLogic gameLogic = new GameLogic(player1, player2, board);

        board.displayBoard();

        gameLogic.startGame();

    }
}
