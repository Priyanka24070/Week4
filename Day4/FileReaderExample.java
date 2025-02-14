//1 Checked Exception (Compile-time Exception)

import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Change this to your file path
        
        try {
            // Creating a FileReader and BufferedReader to read the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            
            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Close the reader after use
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
