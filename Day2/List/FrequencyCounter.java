import java.util.*;

public class FrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();//Create an empty HashMap to store the frequency of each string.

        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1); //use frequencyMap.getOrDefault(item, 0) + 1 to set current value of item 0 
        }
        
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> result = countFrequency(words);
        System.out.println(result); // Output: {apple=2, banana=1, orange=1}
    }
}
