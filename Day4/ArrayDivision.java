//9. Nested try-catch Block
import java.util.Scanner;

public class ArrayDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking array input
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter " + size + " elements for the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Taking the index and divisor as input
        System.out.print("Enter the index to access: ");
        int index = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        try {
            // Trying to access the element at the given index
            try {
                int element = array[index];
                // Trying to divide the element by the divisor
                try {
                    int result = element / divisor;
                    System.out.println("Division result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (Exception e) {
            // Handle other general exceptions
            System.out.println("An unexpected error occurred.");
        } finally {
            scanner.close(); // Closing the scanner
        }
    }
}
