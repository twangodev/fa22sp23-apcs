package hw.linearfunctions;

import java.util.Scanner;

public class LinearFunction implements LinearFunctionMethods {

    private double slope, yInt;

    public LinearFunction(double slope, double yInt) {
        this.slope = slope;
        this.yInt = yInt;
    }

    @Override
    public double getSlope() {
        return slope;
    }

    @Override
    public double getYIntercept() {
        return yInt;
    }

    @Override
    public double getRoot() {
        return getXValue(0.0);
    }

    @Override
    public double getYValue(double x) {
        return slope * x + yInt;
    }

    @Override
    public double getXValue(double y) {
        return (y - yInt) / slope;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("What is the slope of your line? ");
        double slope = kb.nextDouble();

        System.out.println("What is the y-intercept of your line? ");
        double yInt = kb.nextDouble();

        LinearFunction line = new LinearFunction(slope, yInt);

        System.out.println("The slope of your line is " + line.getSlope());
        System.out.println("The y-intercept of your line is " + line.getYIntercept());
        System.out.println("The root of your line is " + line.getRoot());

    }

}
