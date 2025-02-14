//4. Multiple Catch Blocks

import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Accepting array size
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            // Initializing the array
            int[] array = new int[size];

            // Taking array input
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }

            // Accepting index input
            System.out.print("Enter the index to retrieve: ");
            int index = scanner.nextInt();

            // Retrieving and printing the value
            System.out.println("Value at index " + index + ": " + array[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            scanner.close();
            System.out.println("Program execution completed.");
        }
    }
}
