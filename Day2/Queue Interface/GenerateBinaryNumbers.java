import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class GenerateBinaryNumbers {

    // Function to generate the first N binary numbers using a queue
    public static ArrayList<String> generateBinaryNumbers(int N) {
        ArrayList<String> result = new ArrayList<>();
        
        // Create a queue and initialize with the first binary number "1"
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        
        // Generate binary numbers
        for (int i = 0; i < N; i++) {
            // Dequeue the front element
            String current = queue.remove();
            
            // Add the current binary number to the result list
            result.add(current);
            
            // Generate the next binary numbers and enqueue them
            queue.add(current + "0");
            queue.add(current + "1");
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Number of binary numbers to generate
        int N = 5;
        
        // Generate binary numbers
        ArrayList<String> binaryNumbers = generateBinaryNumbers(N);
        
        // Output the result
        System.out.println("First " + N + " Binary Numbers: " + binaryNumbers);
    }
}
