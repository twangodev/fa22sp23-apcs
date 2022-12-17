package hw;

import java.util.Random;

// James Ding
public class Statistics {
    int[] data;
    int[] counter;

    public Statistics(int a) {
        data = new int[a];
        counter = new int[a / 50];
        Random r = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (r.nextGaussian() * 125 + 500);
            counter[data[i] / 50]++;
        }

    }

    public static void main(String[] args) {
        Statistics myStat = new Statistics(1000);
        myStat.printDistribution();
        System.out.println("The mean is " + myStat.getMean());
        System.out.println("The mode is " + myStat.getMode());
    }

    /**
     * Returns the maximum value in the data set
     *
     * @return The maximum integer
     */
    private int getMaxHeight() {
        int max = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > max) max = counter[i];
        }
        return max;
    }

    /**
     * Calculates the mode of the data set
     *
     * @return The mode
     */
    public int getMode() {
        int max = 0, modeIndex = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > max) {
                max = counter[i];
                modeIndex = i;
            }
        }
        return modeIndex * 50;

    }

    /**
     * Calculate the mean of the data
     *
     * @return The mean
     */
    public int getMean() {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum / data.length;
    }

    /**
     * Returns the distribution of the data set
     *
     * @return The number of data points in each range (50)
     */
    public int[] distribution() {
        return counter;
    }

    /**
     * Displays the distribution of the data set
     */
    public void printDistribution() {
        int max = getMaxHeight();
        System.out.println("Max = " + max);
        for (int level = max; level > 0; level--) {
            for (int i = 0; i < counter.length; i++) {
                if (counter[i] < level) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }
}