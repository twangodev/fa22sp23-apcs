package classwork.bankaccount;

import java.util.Arrays;

// James Ding
public class Tester {

    public static void main(String[] args) {
        String[] names = {"Mr. Shen", "Bob", "Jeremy", "Christine", "James", "Emily", "Aston", "Aiden",
                "Kyle", "Jacob", "Bryan", "Rapunzel", "Ellen", "Ethan", "Jennayce", "Kirat", "Leo"};
        BankAccount[] bankAccounts = new BankAccount[names.length];
        int id = 1000;
        double money = 9999.99;
        bankAccounts[0] = new BankAccount(id, names[0], money);
        System.out.println(bankAccounts[0]);

        // Part 1: instantiate the rest of the accounts in the array ba with increasing id, name from names, random money between 100 and 10000
        for (int i = 1; i < bankAccounts.length; i++) {
            bankAccounts[i] = new BankAccount(++id, names[i], Math.random() * 9901 + 100);
        }

        // Part 2: CCA gives a schoolaship of $1000 to all 'poor' students who has less than $500
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getBalance() < 500) bankAccount.deposit(500);
        }

        // Part 3: print a list of the account info
        System.out.println("List of accounts:");
        System.out.println(Arrays.toString(Arrays.stream(bankAccounts).map(BankAccount::toString).toArray()));

        // Part 4: CCA charges $2000 tuition to all students who can afford it
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getBalance() > 2000) bankAccount.withdraw(2000);
        }

        // Part 5: display the accounts that cannot afford the next tuition
        System.out.println("The following students cannot afford the next tuition:");
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getBalance() < 2000) System.out.println(bankAccount);
        }

    }

}
