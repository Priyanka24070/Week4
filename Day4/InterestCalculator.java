//6. throw vs. throws (Exception Propagation)
public class InterestCalculator {

    // Method to calculate interest
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        // Validate inputs and throw IllegalArgumentException if amount or rate is negative
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive.");
        }
        
        // Calculate interest
        double interest = amount * rate * years / 100;
        return interest;
    }

    public static void main(String[] args) {
        try {
            // Sample values for amount, rate, and years
            double amount = 1000;
            double rate = 5;
            int years = 3;
            
            // Call the calculateInterest method and print the result
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);
            
        } catch (IllegalArgumentException e) {
            // Handle exception when amount or rate is invalid
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
