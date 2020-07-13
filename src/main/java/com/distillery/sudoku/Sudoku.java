package com.distillery.sudoku;

public class Sudoku {
    private Sudoku() {
        throw new UnsupportedOperationException("Can't instantiate this class");
    }

    /**
     * Sudoku is played on a grid of 9 x 9 spaces. Within the rows and columns are 9 “squares” (made up of 3 x 3 spaces).
     * Each row, column and square (9 spaces each) needs to be filled out with the numbers 1-9,
     * without repeating any numbers within the row, column or square.
     * <p>
     * To validate a sudoku this method iterates all elements in if it finds a `.` (dot) value, the method will try to fill it up
     * with a possible value following the rules described above, if it succeeds it will continutes until it finishes iterating the board
     * and returning True.
     * <p>
     * If it does not succeed it will stop the iteration and return false.
     * <p>
     * if it finds a number between 1 and 9 it makese sure it passes Sudoku rules:
     */
    public static boolean isValidSudoku(Character[][] board) {

        if (board == null || board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException("This is not a sudoku board");
        }

        for (int row = 0; row < board.length; row++) {

            for (int column = 0; column < board[0].length; column++) {

                Character sudokuElement = board[row][column];
                if (sudokuElement == '.' && !findPossibleSolution(board, row, column)) {
                    return false;
                } else if (!isValidValue(board, row, column)) {
                    return false;
                }

            }
        }

        return true;
    }

    /**
     * Checks number is not repeated in the same row, column or 3x3 grid.
     * if it is repeated false will be returned.
     *
     * NOTE: As a performance improvement, we might add some cache as lists for rows, columns and subGrids,
     * to avoid having to re-iterate them everytime, so wcould have in constant time the instances of a value in row, column subGrid.
     */
    private static boolean isValidValue(Character[][] board, int row, int column) {
        int rowGrid = findGridRow(row);
        int columnGrid = findGridColumn(column);

        return isValueNotRepeatedInSubGrid(row, column, board, rowGrid, columnGrid) &&
                isValueNotRepeatedInRow(row, column, board) &&
                isValueNotRepeatedInColumn(row, column, board);
    }

    private static boolean isValueNotRepeatedInColumn(int currentRow, int currentColumn, Character[][] board) {
        char sudokuElement = board[currentRow][currentColumn];

        for (int row = 0; row < board.length; row++) {
            if (row == currentRow) {
                continue;
            }
            if (board[row][currentColumn] == sudokuElement) {
                return false;
            }
        }
        return true;

    }

    private static boolean isValueNotRepeatedInRow(int currentRow, int currentColumn, Character[][] board) {
        char sudokuElement = board[currentRow][currentColumn];

        for (int column = 0; column < board[0].length; column++) {
            if (column == currentColumn) {
                continue;
            }
            if (board[currentRow][column] == sudokuElement) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check is the subGrid of 3x3 contains the current value repeated.
     */
    private static boolean isValueNotRepeatedInSubGrid(int currentRow, int currentColumn, Character[][] board, int rowGrid, int columnGrid) {
        char sudokuElement = board[currentRow][currentColumn];
        for (int row = rowGrid; row < rowGrid + 3; row++) {
            for (int column = columnGrid; column < columnGrid + 3; column++) {
                if (row == currentRow && column == currentColumn) {
                    continue;
                }
                if (board[row][column] == sudokuElement)
                    return false;
            }
        }
        return true;
    }

    private static int findGridColumn(int column) {
        return findGridRow(column);
    }

    private static int findGridRow(int row) {

        if (!(row >= 0 && row <= 9)) {
            throw new UnsupportedOperationException("Can't calculate grid it belongs to.");
        }
        if (row <= 2) {
            return 0;
        } else if (row <= 5) {
            return 3;
        } else {
            return 6;
        }
    }

    /**
     * Tries to find a possible solution for a specific position in a board,
     * if it succeeds returns true and fill sup the position with the new value.
     * <p>
     * NOTE: This will only work if the column and row of the missing value does not contain another '.' value.
     */
    private static boolean findPossibleSolution(Character[][] board, int row, int column) {
        for (int solution = 1; solution <= 9; solution++) {
            board[row][column] = String.valueOf(solution).charAt(0);
            if (isValidValue(board, row, column)) {
                return true;
            }
        }
        board[row][column] = '.';
        return false;
    }

    public static void printBoard(Character[][] board) {

        for (int row = 0; row < board.length; row++) {
            StringBuilder rowSeparator = new StringBuilder("\n");
            boolean rowCycle = (row + 1) % 3 == 0;
            for (int column = 0; column < board[0].length; column++) {
                String columnValue = "";
                if ((column + 1) % 3 == 0) {
                    columnValue = String.format("| %c ||", board[row][column]);
                    if (rowCycle) {
                        rowSeparator.append("------");
                    }

                } else {
                    columnValue = String.format("| %c ", board[row][column]);
                    if (rowCycle) {
                        rowSeparator.append("----");
                    }
                }
                System.out.print(columnValue);
            }
            if (!rowSeparator.toString().equals("\n")) {
                rowSeparator.append("\n");
            }
            System.out.print(rowSeparator);
        }
    }

}
