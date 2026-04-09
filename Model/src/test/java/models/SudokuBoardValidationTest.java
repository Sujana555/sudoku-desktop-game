package models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import sudoku.model.models.SudokuBoard;
import sudoku.model.solver.BacktrackingSudokuSolver;
import sudoku.model.exceptions.FillingBoardSudokuException;

public class SudokuBoardValidationTest {

    private SudokuBoard board;

    @BeforeEach
    public void setUp() {
        board = new SudokuBoard(new BacktrackingSudokuSolver());
    }

    @Test
    public void testEmptyBoardIsValid() {
        // An empty board (all zeros) should be valid
        // since no rules are violated
        assertTrue(board.isValidSudoku(),
                "Empty board should be valid");
    }

    @Test
    public void testSolvedBoardIsValid() throws FillingBoardSudokuException {
        // A fully solved board should be valid
        board.solveGame();
        assertTrue(board.isValidSudoku(),
                "Solved board should be valid");
    }

    @Test
    public void testSolvedBoardIsComplete() throws FillingBoardSudokuException {
        // A solved board should trigger end game
        board.solveGame();
        assertTrue(board.checkEndGame(),
                "Solved board should be detected as complete");
    }

    @Test
    public void testSetFieldUpdatesValue() {
        // Setting a field value should be retrievable
        board.setField(0, 0, 5);
        assertEquals(5, board.getField(0, 0).getValue(),
                "Field value should be updated to 5");
    }

    @Test
    public void testBoardSizeIsNine() {
        assertEquals(9, board.getSize(),
                "Board size should be 9");
    }
}