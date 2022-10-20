package classwork.automobile;

public class Automobile {

    private double mpg, gallons;

    public Automobile(double mpg) {
        this.mpg = mpg;
        this.gallons = 0;
    }

    public void fillUp(double gallons) {
        this.gallons += gallons;
    }

    public void takeTrip(double miles) {
        this.gallons -= miles / mpg;
    }

    public double reportFuel() {
        return this.gallons;
    }

}
