package hw07;

import java.util.Scanner;

public class RadiusOfCircle {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("What is the area? ");
        double input = kb.nextDouble();
        System.out.println("Radius of your circle is " + calculateRadius(input));
    }

    private static double calculateRadius(double area) {
        return Math.sqrt(area/Math.PI);
    }

}
