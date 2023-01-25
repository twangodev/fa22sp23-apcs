package hw.montecarlo;

public class MonteCarlo {

    public double h, k, r;

    public MonteCarlo(double h, double k, double r) {
        this.h = h;
        this.k = k;
        this.r = r;
    }

    private double raindropAtOrigin() {
        return r * 2 * Math.random() - r;
    }

    public double nextRainDropX() {
        return h + raindropAtOrigin();
    }

    public double nextRainDropY() {
        return k + raindropAtOrigin();
    }

    public boolean insideCircle(double x, double y) {
        return Math.pow(x - h, 2) + Math.pow(y - k, 2) <= Math.pow(r, 2);
    }

}
