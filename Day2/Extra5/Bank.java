import java.util.*;

class BankingSystem {
    private HashMap<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    // Add a new account
    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Request a withdrawal
    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal requested for Account: " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Process all withdrawal requests
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for Account: " + accountNumber);
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " - Balance: $" + entry.getKey());
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        // Adding accounts
        bank.addAccount(101, 5000.00);
        bank.addAccount(102, 2500.50);
        bank.addAccount(103, 7800.75);

        // Request withdrawals
        bank.requestWithdrawal(101);
        bank.requestWithdrawal(103);

        System.out.println("----------------------");
        bank.displaySortedAccounts();
        System.out.println("----------------------");
        
        // Process withdrawals
        bank.processWithdrawals();
    }
}
