package hw;

import java.util.ArrayList;

public class Knapsack {

    public static void main (String[] args) {
        int[] bricks = {12, 4, 2, 1};
        System.out.println(knapsack(15, bricks, 0));
    }

    private static ArrayList<Integer> knapsack(int g, int[] bricks, int i) {

        if (g == 0) return new ArrayList<>();
        if (i == bricks.length - 1) {
            if (bricks[i] <= g) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(bricks[i]);
                return result;
            }
            return new ArrayList<>();
        }

        ArrayList<Integer> wo = knapsack(g, bricks, i + 1);
        if (bricks[i] > g) return wo;
        ArrayList<Integer> w = knapsack(g-bricks[i], bricks, i + 1);
        w.add(0, bricks[i]);
        if (sum(w) > sum(wo)) return w;
        return wo;
    }

    private static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

}

