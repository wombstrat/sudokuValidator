# Sudoku Validator
This Sudoku class only validates if a board is valid, given the next rules https://sudoku.com/how-to-play/sudoku-rules-for-complete-beginners/

The '.' feature only it's suggested base don the rules of the same value, if a column or row of a '.' also contains a different '.' the suggestion will not work, 
due this is not a sudoku resolver.


Check [SudokuTest](https://github.com/wombstrat/sudokuValidator/blob/master/src/test/java/com/distillery/sudoku/SudokuTest.java) class for scenarios tested, and [Sudoku](https://github.com/wombstrat/sudokuValidator/blob/master/src/main/java/com/distillery/sudoku/Sudoku.java) utility class to see implementation.

# TODO

Use logger instead of Sysout and implement the sudoku resolver, based maybe in genetic algorithms.

