package hw.bank;

import java.util.Arrays;
import java.util.Comparator;

public class BankAccountBalanceComparator implements Comparator<BankAccount> {

    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return Double.compare(o1.getBalance(), o2.getBalance());
    }

    public static void main(String[] args) {
        BankAccount myCA = new BankAccount(1000, "Bill Gates", 10_000_000);
        BankAccount[] ba = new BankAccount[5];
        ba[0] = myCA;
        ba[1] = new BankAccount(100, "Elon", 11.05);
        ba[2] = new BankAccount(101, "Ethan", 11.15);
        ba[3] = new BankAccount(102, "Jason", 211.05);
        ba[4] = new BankAccount(103, "Aston", 11111.05);
        // Part 1
        Arrays.sort(ba);
        System.out.println(Arrays.toString(ba));
        // Part 2
        Arrays.sort(ba, new BankAccountBalanceComparator());
        System.out.println(Arrays.toString(ba));
    }

}
