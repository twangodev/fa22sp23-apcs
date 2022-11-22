package hw.dist;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter the A value for the line: ");
        DistToLine.A = kb.nextDouble();
        System.out.print("Enter the B value for the line: ");
        DistToLine.B = kb.nextDouble();
        System.out.print("Enter the C value for the line: ");
        DistToLine.C = kb.nextDouble();

        System.out.print("Enter the x coordinate of the point: ");
        double x = kb.nextDouble();
        System.out.print("Enter the y coordinate of the point: ");
        double y = kb.nextDouble();
        System.out.println("\nThe distance from the point to the line is: " + DistToLine.getDist(x, y));
    }

}
