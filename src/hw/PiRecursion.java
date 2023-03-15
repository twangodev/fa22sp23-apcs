package hw;

public class PiRecursion {

    public double calculatePiTrail(int multiplier, int iter, int max) {
        int denominator = iter * 2 - 1;
        double i = multiplier * 1.0 / denominator;
        if (iter == max) {
            return i;
        }
        return i + calculatePiTrail(-multiplier, iter + 1, max);
    }

    public double calculatePi(int max) {
        return 4 * calculatePiTrail(1, 1, max);
    }

    public static void main(String[] args) {
        PiRecursion pi = new PiRecursion();
        System.out.println(pi.calculatePi(100));
    }

}
