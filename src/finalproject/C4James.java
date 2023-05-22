package finalproject;

import java.awt.*;

public class C4James extends C4Player {

    public C4James(Color c, Color cc, String n, C4Board b) {
        super(c, cc, n, b);
    }

    private int randomSelect(int[] validLocations) {
        return validLocations[(int) (Math.random() * validLocations.length)];
    }

    private Decision optimizedMiniMax(SimulationBoard board, int depth, double alpha, double beta, boolean maximizing) {
        int[] validLocations = board.getValidColumns();
        boolean isTerminal = board.isTerminal();
        if (depth == 0 || isTerminal) {
            if (isTerminal) {
                if (board.winningMove(1)) return new Decision(-1, SimulationBoard.WIN_SCORE);
                else if (board.winningMove(2)) return new Decision(-1, -SimulationBoard.WIN_SCORE);
                else return new Decision(-1, 0);
            } else {
                return new Decision(-1, board.evaluateState(1));
            }
        }

        int value;
        int choice = randomSelect(validLocations);
        if (maximizing) {
            value = Integer.MIN_VALUE;
            for (int col : validLocations) {
                System.out.println("A- Placing in column " + col + " with depth " + depth + " and alpha " + alpha + " and beta " + beta + ".");
                SimulationBoard copy = board.copy();
                copy.place(col, 1);
                System.out.println(copy);
                System.out.println(copy.evaluateState(1));
                int score = optimizedMiniMax(copy, depth - 1, alpha, beta, false).score;
                if (score > value) {
                    value = score;
                    choice = col;
                }
                alpha = Math.max(alpha, value);
                if (alpha >= beta) break;
            }
        } else {
            value = Integer.MAX_VALUE;
            for (int col : validLocations) {
                System.out.println("I- Placing in column " + col + " with depth " + depth + " and alpha " + alpha + " and beta " + beta + ".");
                SimulationBoard copy = board.copy();
                copy.place(col, 2);
                System.out.println(copy);
                System.out.println(copy.evaluateState(1));
                int score = optimizedMiniMax(copy, depth - 1, alpha, beta, true).score;
                if (score < value) {
                    value = score;
                    choice = col;
                }
                beta = Math.min(beta, value);
                if (alpha >= beta) break;
            }
        }
        return new Decision(choice, value);
    }

    @Override
    public int move(int millis) {
        int rows = board.getGrid().getNumRows();
        int cols = board.getGrid().getNumCols();
        SimulationBoard boardSim = new SimulationBoard(rows, cols, 4);
        boardSim.loadGameState(board, getColor());
        System.out.println(boardSim);
        Decision d = optimizedMiniMax(boardSim, 6, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        System.out.println(d);
        return d.column;
    }

    @Override
    public boolean isHuman() {
        return false;
    }

    private static class Decision {

        protected int column;
        protected int score;

        public Decision(int column, int score) {
            this.column = column;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Chose column " + column + " with score " + score + ".";
        }

    }

}
