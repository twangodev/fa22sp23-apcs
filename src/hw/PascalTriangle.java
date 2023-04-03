package hw;

import java.util.HashMap;

public class PascalTriangle {

    private static final HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int rows = 10;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascalCoefficient(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int pascalCoefficient(int i, int j) {
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result;
        if (j == 0 || i == j) {
            result = 1;
        } else {
            result = pascalCoefficient(i-1, j-1) + pascalCoefficient(i-1, j);
        }
        memo.put(key, result);
        return result;
    }

}
