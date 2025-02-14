//5. try-with-resources (Auto-closing Resources)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) {
        // Using try-with-resources to ensure the file is closed after reading
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            // Reading the first line of the file
            String firstLine = reader.readLine();

            if (firstLine != null) {
                System.out.println("First line of the file: " + firstLine);
            } else {
                System.out.println("The file is empty.");
            }
        } catch (IOException e) {
            // Catching any IOException (e.g., file not found)
            System.out.println("Error reading file");
        }
    }
}
