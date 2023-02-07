package hw;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BigBucksTester {

    public static void main(String[] args) {

        NumberFormat formatter= NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);

        String name;
        ArrayList<BankAccount> accounts = new ArrayList<>();


        int id = 0;
        do {
            System.out.print("Please enter the name to whom the account belongs. (Type EXIT to quit) ");

            Scanner kb = new Scanner(System.in);
            name = kb.nextLine();

            if (!name.equalsIgnoreCase("EXIT")) {
                System.out.print("Please enter the amount of the deposit. ");
                double amount = kb.nextDouble();
                System.out.println();

                accounts.add(new BankAccount(++id, name, amount));
            }

        } while (!name.equalsIgnoreCase("EXIT"));

        BankAccount richest = accounts.get(0);
        double richestBalance = richest.getBalance();
        String richestName = richest.getName();

        for (BankAccount account : accounts) {
            if (account.getBalance() > richestBalance) {
                richestBalance = account.getBalance();
                richestName = account.getName();
            }
        }

        System.out.println("The richest person is " + richestName + " with $" + formatter.format(richestBalance));

    }

}
