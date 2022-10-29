package hw;

import java.util.Arrays;

// James Ding
public class Statistics2 {

    double[] array;

    public static double[] xyBoxMuller() {
        double u = Math.random(), v = Math.random();
        // Use box-muller method to generate random points that are normally distributed
        double sqrt = Math.sqrt(-2 * Math.log(u));
        double x = sqrt * Math.cos(2 * Math.PI * v);
        double y = sqrt * Math.sin(2 * Math.PI * v);
        return new double[]{x, y};
    }

    public Statistics2(int size) {
        array = new double[size];
        boolean lock = false;
        double[] prevBoxMuller = xyBoxMuller();
        for (int i = 0; i < size; i++) {
            if (lock) {
                array[i] = prevBoxMuller[1];
            } else {
                double[] boxMuller = xyBoxMuller();
                array[i] = boxMuller[0];
                prevBoxMuller = boxMuller;
            }
            lock = !lock;
        }
    }

    public double mean() {
        double sum = 0;
        for (double d : array) {
            sum += d;
        }
        return sum / array.length;
    }

    public double standardDeviation() {
        double mean = mean();
        double sum = 0;
        for (double d : array) {
            sum += Math.pow(d - mean, 2);
        }
        return Math.sqrt(sum / (array.length - 1));
    }

    public int[] dotPlot(double min, double max, double density) {
        double distance = Math.abs(max - min);
        int partitions = (int) (distance / density);

        int[] dotPlot = new int[partitions];
        for (double d: array) {
            if (d < min || d > max) continue;
            dotPlot[(int) ((d - min) / density)]++;
        }
        return dotPlot;
    }

    public static String stringDotPlot(int[] dotPlot) {
        StringBuilder sb = new StringBuilder();

        int max = 0;
        for (int i : dotPlot) {
            if (i > max) max = i;
        }

        for (int movingMax = max; movingMax > 0; movingMax--) {
            for (int i: dotPlot) {
                if (i >= movingMax) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        for (int i = 0; i < dotPlot.length; i++) sb.append("-");
        return sb.toString();
    }

    public static void main(String[] args) {
        Statistics2 s = new Statistics2(100);
        System.out.println(stringDotPlot(s.dotPlot(-6, 6, 0.1)));
    }

}
