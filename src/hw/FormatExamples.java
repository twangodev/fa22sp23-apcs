package hw;

import java.util.Arrays;

// James Ding
public class FormatExamples {

    public static void main(String[] args) {

        double foo = (double) 8000 / 3;
        System.out.format("This is %,10.2f %,d %-10s\n", foo, 400000000, "good");
        String s = String.format("This is %10.2f%% %02d %-10s\n", foo, 4, "good");
        System.out.println(s);

        int[] num = {7012, 26, 729, 23453, 98};
        double[] money = {1000123.34, 187.91, 571267.03, 890, 38759.5};
        int[] time = {814, 1106, 1452, 35, 1406};
        double total = Arrays.stream(money).sum();

        for (int i = 0; i < num.length; i++) {
            System.out.format("%-15d $%-15.2f %15.1f%% %15d:%02d\n", num[i], money[i], money[i] / total * 100, time[i] / 100, time[i] % 100);
        }

    }

}
