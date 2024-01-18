public class Board {
    private char[][] board;

    public Board() {
        board = new char[10][10];
        emptyBoard();
    }

    public void emptyBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        int k = 10;
        System.out.println(" 1   2   3   4   5   6   7   8    9  10");
        for (int i = 0; i < 10; i++) {
            System.out.print(" ");

            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j]);
                if (j < 10) {
                    System.out.print(" | ");

                }
            }
            System.out.println(" " + k);
            k += 10;

            if (i < 9) {
                System.out.println("---|---|---|---|---|---|---|---|---|---|");
            }
        }
    }

    public int[] makeMove(int position, char playerSymbol) {
        if (isMoveValid(position)) {
            int row = (position - 1) / 10;
            int col = (position - 1) % 10;

            if (board[row][col] == ' ') {
                board[row][col] = playerSymbol;
                return new int[]{row, col};
            } else {
                throw new IllegalArgumentException("To miejsce jest już zajęte. Wybierz inne pole.");
            }
        }
        return null;
    }

    public boolean isMoveValid(int position) {
        if (position >= 1 && position <= 100) {
            int row = (position - 1) / 10;
            int col = (position - 1) % 10;

            if (board[row][col] == ' ') {
                return true;
            } else {
                System.out.println("To miejsce jest już zajęte. Wybierz inne pole.");
                return false;
            }
        } else {
            System.out.println("Wybrałeś nieprawidłowy numer. Musisz wybrać od 1 do 100.");
            return false;
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWinAtPosition(int row, int col, char playerSymbol) {
        int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

        for (int[] direction : directions) {
            int count = 1;

            for (int i = 1; i <= 4; i++) {
                int newRow = row + i * direction[0];
                int newCol = col + i * direction[1];

                if (newRow >= 0 && newRow < 10 && newCol >= 0 && newCol < 10 &&
                        board[newRow][newCol] == playerSymbol) {
                    count++;
                } else {
                    break;
                }
            }

            for (int i = 1; i <= 4; i++) {
                int newRow = row - i * direction[0];
                int newCol = col - i * direction[1];

                if (newRow >= 0 && newRow < 10 && newCol >= 0 && newCol < 10 &&
                        board[newRow][newCol] == playerSymbol) {
                    count++;
                } else {
                    break;
                }
            }

            if (count >= 5) {
                return true;
            }
        }

        return false;
    }
}
