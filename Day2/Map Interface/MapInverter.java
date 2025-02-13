import java.util.*;

public class MapInverter {

    public static void main(String[] args) {
        // Sample input map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        // Print the inverted map
        System.out.println(invertedMap);
    }

    // Function to invert a Map<K, V> to Map<V, List<K>>
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        // Iterate through each entry in the original map
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // If the value already exists as a key in invertedMap, add the key to the list
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return invertedMap;
    }
}
