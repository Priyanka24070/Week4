import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    // Function to compute the union of two sets
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);  // Copy the first set
        result.addAll(set2);  // Add all elements from the second set
        return result;
    }

    // Function to compute the intersection of two sets
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);  // Copy the first set
        result.retainAll(set2);  // Keep only elements that are in both sets
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
        
        // Compute and display the union
        Set<Integer> unionSet = union(set1, set2);
        System.out.println("Union: " + unionSet);
        
        // Compute and display the intersection
        Set<Integer> intersectionSet = intersection(set1, set2);
        System.out.println("Intersection: " + intersectionSet);
    }
}
