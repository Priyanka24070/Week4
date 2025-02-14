//10. Bank Transaction System (Checked + Custom Exception)

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to withdraw an amount
    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        // Check if the amount is negative
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        
        // Check if the amount exceeds the available balance
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        
        // Subtract the amount from the balance
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    // Getter method for balance
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Create an account with initial balance

        try {
            // Attempt to withdraw a valid amount
            account.withdraw(500.0);

            // Attempt to withdraw an invalid (negative) amount
            account.withdraw(-100.0);
        } catch (InsufficientBalanceException e) {
            // Handle insufficient balance
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            // Handle invalid withdrawal amount
            System.out.println(e.getMessage());
        }
    }
}
