public class GameLogic {

    private Player player1;
    private Player player2;
    private Board board;
    private int currentPlayer;

    public GameLogic(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.currentPlayer = 1;
    }

    public void startGame() {
        System.out.println("Witaj w grze Kółko i krzyżyk");

        while (!board.isBoardFull() && !board.checkForWin('X') && !board.checkForWin('O')) {
            Player currentPlayerObj = (currentPlayer == 1) ? player1 : player2;

            System.out.println(currentPlayerObj.getName() + ", twój ruch");
            int move;

            do {
                move = currentPlayerObj.getMove();
            } while (!board.isMoveValid(move));

            char playerSymbol = (currentPlayer == 1) ? 'X' : 'O';

            board.makeMove(move, playerSymbol);
            board.displayBoard();

            if (board.checkForWin(playerSymbol)) {
                System.out.println(currentPlayerObj.getName() + " wygrywa!");
                currentPlayerObj.addPoints();
                break; //mamy zwycięzcę
            } else if (board.isBoardFull()) {
                System.out.println("Remis!");
                break;
            }

            // przelacze graczy
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }


        System.out.println("Wyniki:");
        System.out.println(player1.getName() + ": " + player1.getPoints() + " punktów");
        System.out.println(player2.getName() + ": " + player2.getPoints() + " punktów");
    }
}
