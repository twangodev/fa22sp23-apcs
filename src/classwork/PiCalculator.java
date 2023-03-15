package classwork;

public class PiCalculator {

    public static double calculatePiTrail(int n) {
        if (n == 1) {
            return n;
        }
        return 1.0 / (n * n) + calculatePiTrail(n - 1);
    }

    public static double calculatePi(int n) {
        return Math.sqrt(calculatePiTrail(n) * 6);
    }

    public static void main(String[] args) {
        System.out.println(calculatePi(10000));
    }

}
