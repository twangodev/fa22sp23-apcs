package hw.montecarlo;

public class MonteCarloTester {

    public static void main(String[] args) {

        MonteCarlo mcObj = new MonteCarlo(5, 3, 2);

        int cirCount = 0;
        double sqrCount = 100;
        for (int i = 0; i < sqrCount; i++) {
            double x = mcObj.nextRainDropX();
            double y = mcObj.nextRainDropY();
            if (mcObj.insideCircle(x, y)) {
                cirCount++;
            }
        }

        System.out.println(4 * cirCount / sqrCount);

    }

}
