package finalproject;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SimulationBoardTest {

    SimulationBoard board = new SimulationBoard(3, 3, 2);
    SimulationBoard uniqueBoard = new SimulationBoard(3, 3, 2);

    @Before
    public void setup() {
        uniqueBoard.place(0, 1);
        uniqueBoard.place(1, 2);
        uniqueBoard.place(2, 3);
        uniqueBoard.place(0, 4);
        uniqueBoard.place(1, 5);
        uniqueBoard.place(2, 6);
        uniqueBoard.place(0, 7);
        uniqueBoard.place(1, 8);
        uniqueBoard.place(2, 9);
    }

    @Test
    public void testPrintBoard() {
        System.out.println("Test print board");
        System.out.println(board);
    }

    @Test
    public void placeLowerRow() {
        System.out.println("Test place lower row");
        board.place(0, 1);
        board.place(1, 1);
        board.place(2, 1);
        System.out.println(board);
    }

    @Test
    public void testUniqueBoard() {
        System.out.println("Test unique board");
        System.out.println(uniqueBoard);
    }

    @Test
    public void getVerticalColumns() {
        System.out.println("Test columns");
        System.out.println(Arrays.deepToString(uniqueBoard.getAllVertical()));
    }

    @Test
    public void getHorizontalRows() {
        System.out.println("Test rows");
        System.out.println(Arrays.deepToString(uniqueBoard.getAllHorizontal()));
    }

    @Test
    public void getPositiveDiagonal() {
        System.out.println("Test positive diagonal");
        System.out.println(Arrays.deepToString(uniqueBoard.getAllPositiveDiagonal()));
    }

    @Test
    public void getNegativeDiagonal() {
        System.out.println("Test negative diagonal");
        System.out.println(Arrays.deepToString(uniqueBoard.getAllNegativeDiagonal()));
    }


}
