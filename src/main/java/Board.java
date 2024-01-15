public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        emptyBoard();
    }

    public void emptyBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    //wyświetlenie planszy
    public void displayBoard() {

        System.out.println("  1  2  3");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---|---|----");
            }
        }
    }
    public void makeMove(int position, char playErSymbol) {
        if (isMoveValid(position)) {
            int row = (position - 1) / 3;
            int col = (position - 1) % 3;

            if (board[row][col] == ' ') {
                board[row][col] = playErSymbol;
            } else {
                System.out.println("To miejsce jest już zajęte . Wybierz inne pole ");
            }
        }

    }
    public boolean isMoveValid(int position) {
        if (position >= 1 && position <= 9) {
            int row = (position - 1) / 3;
            int col = (position - 1) % 3;

            if (board[row][col] == ' ') {
                return true;
            } else {
                System.out.println("To miejsce jest już zajęte. Wybierz inne pole.");
                return false;
            }
        } else {
            System.out.println("Wybrałeś nieprawidłowy numer. Musisz wybrać od 1 do 9.");
            return false;
        }
    }

    public boolean isBoardFull() {
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j<3; j++){
                if (board[i][j] == ' ' ){
                    return false ; // <-- jako puste pole
                }
            }
        }
        return true;
    }
    public boolean checkForWin(char playerSymbol) {

        for (int i = 0; i < 3; i++) {
            //rzad
            if (board[i][0] == playerSymbol && board[i][1] == playerSymbol && board[i][2] == playerSymbol) {
                return true;
            }

            //kolumna
            if (board[0][i] == playerSymbol && board[1][i] == playerSymbol && board[2][i] == playerSymbol) {
                return true;
            }
        }

        // przekatna
        if (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) {
            return true;
        }

        if (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol) {
            return true;
        }

        return false;
    }

}

