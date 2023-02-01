package hw;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private char currentPlayer;

    public String printBoard() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            result.append("| ");
            for (int j = 0; j < 3; j++) {
                result.append(board[i][j]).append(" | ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public TicTacToe(char currentPlayer) {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        this.currentPlayer = currentPlayer;
    }

    public boolean move(int row, int col, boolean override) {
        if (override || board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        }
        return false;
    }

    public boolean checkPossiblePattern(char[] pattern) {
        return Arrays.equals(pattern, new char[]{'X', 'X', 'X'}) || Arrays.equals(pattern, new char[]{'O', 'O', 'O'});
    }

    public boolean checkRow(int row) {
        return checkPossiblePattern(board[row]);
    }

    public boolean checkColumn(int col) {
        return checkPossiblePattern(new char[]{board[0][col], board[1][col], board[2][col]});
    }

    public boolean checkDiagonal() {
        return checkPossiblePattern(new char[]{board[0][0], board[1][1], board[2][2]}) || checkPossiblePattern(new char[]{board[0][2], board[1][1], board[2][0]});
    }

    public char checkWin() {
        boolean win = false;
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) || checkColumn(i)) {
                win = true;
                break;
            }
        }
        if (!win) {win = checkDiagonal();}
        return win ? (currentPlayer == 'X' ? 'O' : 'X') : ' ';
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe('X');
        Scanner kb = new Scanner(System.in);
        while (game.checkWin() == ' ') {
            System.out.println("Current player: " + game.currentPlayer);
            System.out.println(game.printBoard());
            System.out.print("Enter the row: ");
            int row = kb.nextInt();
            System.out.print("Enter the column: ");
            int col = kb.nextInt();
            if (!game.move(row, col, false)) {
                System.out.println("Invalid move");
            }
        }
        System.out.println(game.printBoard());
        System.out.println("Winner: " + game.checkWin());
    }

}
