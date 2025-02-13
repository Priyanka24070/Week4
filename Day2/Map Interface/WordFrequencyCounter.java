import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // Text input
        String text = "Hello world, hello Java!";
        
        // Call the function to get word frequencies
        Map<String, Integer> wordFrequencies = countWordFrequencies(text);
        
        // Print the word frequencies
        System.out.println(wordFrequencies);
    }

    // Function to count the frequency of words in a text
    public static Map<String, Integer> countWordFrequencies(String text) {
        // Create a HashMap to store the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        // Convert the text to lowercase and remove punctuation
        text = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        
        // Split the text into words using whitespace as a delimiter
        String[] words = text.split("\\s+");
        
        // Iterate through each word
        for (String word : words) {
            // If the word is not empty, update the frequency map
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        return frequencyMap;
    }
}
