public class GameLogic {

    private Player player1;
    private Player player2;
    private Board board;
    private int currentPlayer;
    private int moveCount;

    public GameLogic(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.currentPlayer = 1;
        this.moveCount=0;
    }

    public void startGame() {
        System.out.println("Witaj w grze Kółko i krzyżyk");

        while (!board.isBoardFull()) {

            Player currentPlayerObj = (currentPlayer == 1) ? player1 : player2;

            System.out.println(currentPlayerObj.getName() + ", twój ruch");
            int move;

            do {
                move = currentPlayerObj.getMove();


            } while (!board.isMoveValid(move));

            char playerSymbol = (currentPlayer == 1) ? 'X' : 'O';

            int[] moveResult = board.makeMove(move, playerSymbol);
            int row = moveResult[0];
            int col = moveResult[1];
            moveCount ++ ;
            board.displayBoard();

            if (board.checkForWinAtPosition(row, col, playerSymbol)) {
                System.out.println(currentPlayerObj.getName() + " wygrywa!");
                currentPlayerObj.addPoints();
                break; // mamy zwycięzcę
            } else if (board.isBoardFull()) {
                System.out.println("Remis!");
                break;
            }

            // przełącz graczy
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        System.out.println("Wyniki:");
        System.out.println(player1.getName() + ": " + player1.getPoints() + " punktów");
        System.out.println(player2.getName() + ": " + player2.getPoints() + " punktów");
        System.out.println("ilość ruchów " + moveCount);
    }
}
