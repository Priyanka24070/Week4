import java.util.HashSet;
import java.util.Set;

public class SetSubsetCheck {

    // Function to check if set1 is a subset of set2
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        return set2.containsAll(set1);  // Returns true if set2 contains all elements of set1
    }

    public static void main(String[] args) {
        // Create two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add elements to both sets
        set1.add(2);
        set1.add(3);
        
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        
        // Check if set1 is a subset of set2
        boolean result = isSubset(set1, set2);
        
        // Output the result
        System.out.println("Is set1 a subset of set2? " + result);
    }
}
