package hw;

import java.util.Scanner;

// James Ding
public class CompoundInterest {

    /**
     * Calculates the amount of years it would take to have double the principle with a specified interest rate
     * @param args Not used
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the principle: ");
        double principle = kb.nextDouble();
        kb.nextLine();
        System.out.print("Enter the interest rate in percent form: ");
        double interest = kb.nextDouble() / 100;
        double rate = 1 + interest;

        int yearsPassed = 0;
        double current = principle;
        while (current < principle * 2) {
            current *= rate;
            yearsPassed++;
            System.out.println(yearsPassed + " year(s) has passed. You now have " + current);
        }
        System.out.println("It took " + yearsPassed + " for your principle to double to " + current);
    }

}
