package classwork;

import java.util.Arrays;

// James Ding
public class Statistics {

    private int[] ints = new int[1000];

    public Statistics() {
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * (1000) + 1);
        }
    }

    public double average() {
        int sum = 0;
        for (int i : ints) {
            sum += i;
        }
        return (double) sum / ints.length;
    }

    public int largest() {
        int largest = 0;
        for (int i : ints) {
            if (i > largest) {
                largest = i;
            }
        }
        return largest;
    }

    public int[] distribution() {
        int[] dist = new int[20];

        for (int i = 0; i < ints.length; i++) {
            int lowerBound = (i * 50) + 1;
            int upperBound = lowerBound + 49;
            for (int j : ints) {
                if (j >= lowerBound && j <= upperBound) {
                    dist[i]++;
                }
            }
        }
        return dist;
    }

    public void main(String[] args) {
        Statistics stats = new Statistics();
        System.out.println("Average: " + stats.average());
        System.out.println("Largest: " + stats.largest());
        System.out.println("Distribution: " + Arrays.toString(stats.distribution()));
    }

}
