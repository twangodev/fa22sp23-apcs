package hw;

import java.util.Arrays;

public class Hanoi {
    public static void main(String args[]) {
        final int level = 10;
        int[][] towers = new int[3][level];
        //initial data
        for (int i = 1; i <= level; i++) {
            towers[0][level - i] = i;
        }

        System.out.println("Initial state: " + Arrays.deepToString(towers));
        moveTower(level, towers, 0, 2, 1);
        System.out.println("Final state: " + Arrays.deepToString(towers));
    }

    // move the top disk from 'from' to 'to'
    private static void moveDisk(int[][] towers, int from, int to) {
        int row = towers[0].length - 1;
        while (row >= 0 && towers[from][row] == 0) {
            row--;
        }
        int disk = towers[from][row];
        towers[from][row] = 0;
        row = towers[to].length - 1;
        while (row >= 0 && towers[to][row] == 0) {
            row--;
        }
        towers[to][row + 1] = disk;
        //print the action
        System.out.println("Moved " + disk + " from " + from + " to " + to);
    }

    private static void moveTower(int level, int[][] towers, int from, int to, int spare) {
        if (level == 1) {
            moveDisk(towers, from, to);
        } else {
            moveTower(level - 1, towers, from, spare, to);
            moveDisk(towers, from, to);
            moveTower(level - 1, towers, spare, to, from);
        }
    }

}

