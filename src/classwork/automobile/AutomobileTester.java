package classwork.automobile;

// James Ding
public class AutomobileTester {

    public static void main(String[] args) {
        Automobile myBmw = new Automobile(24);
        myBmw.fillUp(20);
        myBmw.takeTrip(100);
        double fuelLeft = myBmw.reportFuel();
        System.out.format("Fuel left: %10.2f %10s\n", fuelLeft, "gallons");

        Automobile myPrius = new Automobile(50);
        myPrius.fillUp(13);
        myPrius.takeTrip(50);
        fuelLeft = myPrius.reportFuel();
        System.out.format("Fuel left: %10.2f %10s", fuelLeft, "gallons");
    }

}
