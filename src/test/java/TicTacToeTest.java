import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTest {


    @Test
    void testOWinsRows(){
    Board board = new Board();
    board.makeMove(1 , '0');
    board.makeMove(2 , '0');
    board.makeMove(3 , '0');
    assertTrue (board.checkForWin('0'));
    }
    @Test
    void testOWinsColumn(){
        Board board = new Board();
        board.makeMove(1 , '0');
        board.makeMove(4 , '0');
        board.makeMove(7 , '0');
        assertTrue (board.checkForWin('0'));
    }
    @Test
    void testOWinsDiagonal(){
        Board board = new Board();
        board.makeMove(1 , '0');
        board.makeMove(5 , '0');
        board.makeMove(9 , '0');
        assertTrue (board.checkForWin('0'));
    }
    @Test
    void testXWinsRows(){
        Board board = new Board();
        board.makeMove(1 , 'X');
        board.makeMove(2 , 'X');
        board.makeMove(3 , 'X');
        assertTrue (board.checkForWin('X'));
    }
    @Test
    void testXWinsColumn(){
        Board board = new Board();
        board.makeMove(1 , 'X');
        board.makeMove(4 , 'X');
        board.makeMove(7 , 'X');
        assertTrue (board.checkForWin('X'));
    }
    @Test
    void testXWinsDiagonal(){
        Board board = new Board();
        board.makeMove(1 , 'X');
        board.makeMove(5 , 'X');
        board.makeMove(9 , 'X');
        assertTrue (board.checkForWin('X'));
    }

    @Test
    void testDraw(){
        Board board = new Board();
        board.makeMove(1 , 'X');
        board.makeMove(2 , '0');
        board.makeMove(3 , '0');
        board.makeMove(4 , '0');
        board.makeMove(5 , '0');
        board.makeMove(6 , 'X');
        board.makeMove(7 , 'X');
        board.makeMove(8 , 'X');
        board.makeMove(9 , '0');
        assertTrue(board.isBoardFull() && !board.checkForWin('X')&& !board.checkForWin('0'));
    }
//    @Test
//    void testWrongMove() {
//        Board board = new Board();
//        board.makeMove(1, 'X');
//        assertThrows(IllegalArgumentException.class, () -> board.makeMove(1, '0'));
//    }




}
