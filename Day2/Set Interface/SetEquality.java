import java.util.HashSet;

public class SetEquality {
    
    public static boolean areSetsEqual(HashSet<Integer> set1, HashSet<Integer> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        // Create two sets
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        // Add elements to both sets
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(3);
        set2.add(2);
        set2.add(1);
        
        // Compare the two sets
        boolean result = areSetsEqual(set1, set2);
        
        // Output the result
        System.out.println("Are the sets equal? " + result);
    }
}
