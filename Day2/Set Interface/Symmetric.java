import java.util.HashSet;
import java.util.Set;

public class Symmetric {

    // Function to compute the symmetric difference of two sets
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        // Create a copy of the first set
        Set<Integer> result = new HashSet<>(set1);
        
        // Perform symmetric difference by removing the intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);  // Get intersection of set1 and set2
        
        // Remove intersection elements from both sets
        result.addAll(set2);          // Add all elements from set2
        result.removeAll(intersection);  // Remove the common elements (intersection)
        
        return result;
    }

    public static void main(String[] args) {
        // Create two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add elements to both sets
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        // Compute and display the symmetric difference
        Set<Integer> symmetricDiff = symmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}
