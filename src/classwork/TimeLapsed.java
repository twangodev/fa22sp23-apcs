package classwork;

import java.util.Scanner;

// James Ding
public class TimeLapsed {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        prompt(kb);
    }

    public static void prompt(Scanner kb) {
        System.out.print("Enter: ");
        int hour = kb.nextInt();
        int minute = kb.nextInt();
        System.out.print("Minutes to pass: ");
        int pass = kb.nextInt();
        System.out.println("The end time is: " + (hour + pass/60) + ":" + (minute + (pass % 60)));
    }

}
