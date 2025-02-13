import java.util.*;

public class MapMerger {

    public static void main(String[] args) {
        // Sample input maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Print the merged map
        System.out.println(mergedMap);
    }

    // Function to merge two maps
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        // Merge map2 into map1
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            // Sum the values if the key exists in both maps, otherwise add the entry from map2
            map1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        
        return map1;
    }
}
