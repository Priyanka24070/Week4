import java.util.*;

public class SetToSortedList {

    // Function to convert a HashSet to a sorted List
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        // Convert the HashSet to a List (ArrayList)
        List<Integer> list = new ArrayList<>(set);
        
        // Sort the List in ascending order
        Collections.sort(list);
        
        return list;
    }

    public static void main(String[] args) {
        // Create a HashSet
        Set<Integer> set = new HashSet<>();
        
        // Add elements to the HashSet
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);
        
        // Convert the HashSet to a sorted List
        List<Integer> sortedList = convertToSortedList(set);
        
        // Output the sorted List
        System.out.println("Sorted List: " + sortedList);
    }
}
