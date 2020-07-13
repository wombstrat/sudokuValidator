package com.distillery.sudoku;

import org.junit.Test;

import static com.distillery.sudoku.Sudoku.isValidSudoku;
import static com.distillery.sudoku.Sudoku.printBoard;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SudokuTest {


    @Test
    public void isBoardValid() {
        Character[][] board = new Character[][]{
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };

        printBoard(board);
        assertTrue(isValidSudoku(board));


    }

    // 5 at 0,0 is repeated at the same row
    @Test
    public void isBoardInvalidBcOfRow() {

        Character[][] board = new Character[][]{
                {'5', '3', '4', '6', '7', '8', '9', '1', '5'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };

        printBoard(board);
        assertFalse(isValidSudoku(board));


    }

    // 5 at 0,0 is repeated at the end of the same column
    @Test
    public void isBoardInvalidBcOfColumn() {

        Character[][] board = new Character[][]{
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'5', '4', '5', '2', '8', '6', '1', '7', '9'}
        };

        printBoard(board);
        assertFalse(isValidSudoku(board));


    }

    // 5 at 0,0 is missing
    // 7 at 4,6 is missing
    // 9 at 8,8 is missing
    @Test
    public void findsPossibleSolution() {

        Character[][] uncompleteBoard = new Character[][]{
                {'.', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '.', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '.'}
        };

        System.out.println("Before modification");
        printBoard(uncompleteBoard);
        assertTrue(isValidSudoku(uncompleteBoard));

        System.out.println("After modification");
        printBoard(uncompleteBoard);


    }


}

