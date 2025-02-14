//7. finally Block Execution
import java.util.Scanner;

public class DivisionWithFinally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            // Perform division
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handle division by zero exception
            System.out.println("Error: Cannot divide by zero.");
        } catch (Exception e) {
            // Catch other exceptions (e.g., invalid input)
            System.out.println("Error: Invalid input.");
        } finally {
            // Ensure this block is always executed
            System.out.println("Operation completed");
        }

        scanner.close(); // Closing the scanner
    }
}

