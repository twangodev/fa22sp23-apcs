package finalproject;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class C4James extends C4Player {

    /**
     * Custom implementation of connect-n, with features for simulation
     */
    public static class SimulationBoard {

        /**
         * The score for a win
         */
        public static int WIN_SCORE = 1000000;

        /**
         * The amount required for a win
         */
        private final int winCount;

        /**
         * The moves that have been made so far.
         * Note that this does not store moves that occurred before the board was loaded.
         */
        public ArrayList<String> moves = new ArrayList<>();

        /**
         * The board, a 2D array of ints.
         * 0 = empty
         * 1 = player 1
         * 2 = player 2
         */
        private int[][] board;

        public SimulationBoard(int rows, int columns, int winCount) {
            board = new int[rows][columns];
            this.winCount = winCount;
        }

        public SimulationBoard(int rows, int columns) {
            this(rows, columns, 4);
        }

        private int actorLookup(Actor actor, Color selfColor) {
            if (actor == null) return 0;
            if (actor.getColor().equals(selfColor)) return 1;
            else return 2;
        }

        public void loadGameState(int[][] board) {
            if (board.length != this.board.length || board[0].length != this.board[0].length) {
                throw new IllegalArgumentException("Board dimensions do not match");
            }
            for (int r = 0; r < this.board.length; r++) {
                System.arraycopy(board[r], 0, this.board[r], 0, this.board[0].length);
            }
        }

        public void loadGameState(C4Board c4Board, Color selfColor) {
            int rows = c4Board.getGrid().getNumRows();
            int columns = c4Board.getGrid().getNumCols();

            board = new int[rows][columns];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    Location loc = new Location(r, c);
                    Actor actor = c4Board.getGrid().get(loc);
                    board[r][c] = actorLookup(actor, selfColor);
                }
            }

            loadGameState(board);
        }

        private int getOpponent(int player) {
            return player == 1 ? 2 : 1;
        }

        private int getCount(int[] arr, int elem) {
            int count = 0;
            for (int i : arr) {
                if (i == elem) count++;
            }
            return count;
        }

        public int[][] getAllHorizontal() {
            int columns = board[0].length;

            ArrayList<int[]> windowArr = new ArrayList<>();
            for (int[] r : board) {
                for (int c = 0; c < columns - winCount + 1; c++) {
                    int[] window = new int[winCount];
                    System.arraycopy(r, c, window, 0, winCount);
                    windowArr.add(window);
                }
            }

            int[][] windows = new int[windowArr.size()][];
            windowArr.toArray(windows);
            return windows;
        }

        public int[][] getAllVertical() {
            int rows = board.length;
            int columns = board[0].length;

            ArrayList<int[]> windowArr = new ArrayList<>();
            for (int c = 0; c < columns; c++) {
                for (int r = 0; r < rows - winCount + 1; r++) {
                    int[] window = new int[winCount];
                    for (int i = 0; i < winCount; i++) {
                        window[i] = board[r + i][c];
                    }
                    windowArr.add(window);
                }
            }

            int[][] windows = new int[windowArr.size()][];
            windowArr.toArray(windows);
            return windows;
        }

        public int[][] getAllPositiveDiagonal() {
            int rows = board.length;
            int columns = board[0].length;
            ArrayList<int[]> windowArr = new ArrayList<>();
            for (int r = winCount - 1; r < rows; r++) {
                for (int c = 0; c < columns - winCount + 1; c++) {
                    int[] window = new int[winCount];
                    for (int i = 0; i < winCount; i++) {
                        window[i] = board[r - i][c + i];
                    }
                    windowArr.add(window);
                }
            }

            int[][] windows = new int[windowArr.size()][];
            windowArr.toArray(windows);
            return windows;
        }

        public int[][] getAllNegativeDiagonal() {
            int rows = board.length;
            int columns = board[0].length;

            ArrayList<int[]> windowArr = new ArrayList<>();
            for (int r = 0; r < rows - winCount + 1; r++) {
                for (int c = 0; c < columns - winCount + 1; c++) {
                    int[] window = new int[winCount];
                    for (int i = 0; i < winCount; i++) {
                        window[i] = board[r + i][c + i];
                    }
                    windowArr.add(window);
                }
            }

            int[][] windows = new int[windowArr.size()][];
            windowArr.toArray(windows);
            return windows;
        }

        public int[][] getAllDiagonal() {
            int[][] positive = getAllPositiveDiagonal();
            int[][] negative = getAllNegativeDiagonal();
            int[][] combined = new int[getAllPositiveDiagonal().length + getAllNegativeDiagonal().length][];
            System.arraycopy(positive, 0, combined, 0, positive.length);
            System.arraycopy(negative, 0, combined, positive.length, negative.length);
            return combined;
        }

        public int evaluateWindow(int[] window, int player) {
            int score = 0;

            int playerCount = getCount(window, player);
            int opponentCount = getCount(window, getOpponent(player));

            if (playerCount == winCount) score += 100;
            else if (playerCount == winCount - 1 && opponentCount == 0) score += 5;
            else if (playerCount == winCount - 2 && opponentCount == 0) score += 2;

            if (playerCount == 0 && opponentCount == winCount - 1) score -= 4;

            return score;
        }

        private int[] getCenterColumn() {
            int[] centerColumn = new int[board.length];
            for (int r = 0; r < board.length; r++) {
                centerColumn[r] = board[r][board[0].length / 2];
            }
            return centerColumn;
        }

        public int evaluateState(int player) {
            int score = 0;

            score += 3 * getCount(getCenterColumn(), player);

            int[][] horizontal = getAllHorizontal();
            int[][] vertical = getAllVertical();
            int[][] diagonal = getAllDiagonal();

            for (int[] window : horizontal) {
                score += evaluateWindow(window, player);
            }
            for (int[] window : vertical) {
                score += evaluateWindow(window, player);
            }
            for (int[] window : diagonal) {
                score += evaluateWindow(window, player);
            }

            return score;
        }

        private boolean winningWindow(int[] window, int player) {
            for (int i : window) {
                if (i != player) return false;
            }
            return true;
        }

        public boolean winningMove(int p) {

            for (int[] window : getAllHorizontal()) {
                if (winningWindow(window, p)) return true;
            }

            for (int[] window : getAllVertical()) {
                if (winningWindow(window, p)) return true;
            }

            for (int[] window : getAllDiagonal()) {
                if (winningWindow(window, p)) return true;
            }

            return false;
        }

        public boolean isTerminal() {
            return getValidColumns().length == 0 || winningMove(1) || winningMove(2);
        }

        public int[] getValidColumns() {
            ArrayList<Integer> validColumns = new ArrayList<>();
            for (int c = 0; c < board[0].length; c++) {
                if (board[0][c] == 0) validColumns.add(c);
            }
            return validColumns.stream().mapToInt(i -> i).toArray();
        }

        public void place(int column, int player) {
            for (int r = board.length - 1; r >= 0; r--) {
                if (board[r][column] == 0) {
                    moves.add("P" + player + "C" + column);
                    board[r][column] = player;
                    return;
                }
            }
        }

        public SimulationBoard copy() {
            SimulationBoard copy = new SimulationBoard(board.length, board[0].length, winCount);
            copy.loadGameState(board);
            copy.moves = this.moves;
            return copy;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int[] row : board) {
                sb.append(Arrays.toString(row)).append("\n");
            }
            return moves.toString() + "\n" + sb;
        }

    }

    int depth;

    public C4James(Color c, Color cc, String n, C4Board b, int depth) {
        super(c, cc, n, b);
        this.depth = depth;
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

        int value = maximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int choice = randomSelect(validLocations);
        int player = maximizing ? 1 : 2;

        for (int col: validLocations) {
            String mode = maximizing ? "Maximizing" : "Minimizing";
            System.out.println(mode + " column " + col + " with depth " + depth + " and alpha " + alpha + " and beta " + beta + "for player " + player + ".");
            SimulationBoard copy = board.copy();
            copy.place(col, player);
            System.out.println(copy);
            System.out.println(copy.evaluateState(player));
            int score = optimizedMiniMax(copy, depth - 1, alpha, beta, !maximizing).score;
            if (maximizing) {
                if (score > value) {
                    value = score;
                    choice = col;
                }
                alpha = Math.max(alpha, value);
            } else {
                if (score < value) {
                    value = score;
                    choice = col;
                }
                beta = Math.min(beta, value);
            }
            if (alpha >= beta) break;
        }

        return new Decision(choice, value);
    }

    @Override
    public int move(int millis) {
        int rows = board.getGrid().getNumRows();
        int cols = board.getGrid().getNumCols();
        SimulationBoard boardSim = new SimulationBoard(rows, cols);
        boardSim.loadGameState(board, getColor());
        System.out.println(boardSim);
        Decision d = optimizedMiniMax(boardSim, depth, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        System.out.println(d);

        if (d.column == -1) return randomSelect(boardSim.getValidColumns());
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
