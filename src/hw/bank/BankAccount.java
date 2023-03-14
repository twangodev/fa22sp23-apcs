package hw.bank;

// James Ding
public class BankAccount implements Comparable<BankAccount> {

    private final int id;
    private final String name;
    private double balance;

    /**
     * Constructor for objects of class BankAccount
     */
    public BankAccount(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1234, "James Ding", 1000);
        System.out.println("Balance: " + account.getBalance());
        account.deposit(100);
        System.out.println("Balance: " + account.getBalance());
        account.withdraw(500);
        System.out.println("Balance: " + account.getBalance());
        account.withdraw(600);
        System.out.println("Balance: " + account.getBalance());
        double newBalance = account.withdraw(10);
        if (newBalance == -1) {
            System.out.println("Insufficient funds");
        }
    }

    /**
     * Retrieves the name of the account
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Adds the given amount to the account balance
     *
     * @return The new balance
     */
    public double deposit(double amount) {
        return balance += amount;
    }

    /**
     * Subtracts the given amount from the account balance
     *
     * @return The new balance
     */
    public double withdraw(double amount) {
        if (amount > balance) {
            return -1; // Insufficient funds
        }
        return balance -= amount;
    }

    @Override
    public int compareTo(BankAccount other) {
        return name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "BankAccount{" + "id=" + id + ", name=" + name + ", balance=" + balance + '}';
    }

}
