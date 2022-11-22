package classwork.bankaccount;

public class BankAccount {
    static int numAccounts = 0;
    public static final String nameBank = "Bank of CCA"; 
    private static double totalAsset = 100_000_000;
    public static String getAddress() {
       // wrong to access obj data: String address = nameOwner;
        return "25500 Industrial Blvd, Hayward, CA94545";
    }

	public static double getAsset() {
		return totalAsset;
	}

    private final int id;
    private final String nameOwner;
    private double balance;

    public BankAccount (int i, String n, double b) {
        id = i;
        nameOwner = n;
        balance = b;
        numAccounts ++;
        totalAsset += b;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
        totalAsset -= amount;
    }

    public double deposit (double money) {
        balance += money;
        totalAsset += money;
        return balance;
    }

    public String toString() {
        return String.format("Account #%5d is owned by %s with $%.2f", id, nameOwner, balance);
    }
}
