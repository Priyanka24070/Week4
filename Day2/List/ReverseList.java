import java.util.*;

public class ReverseList {
    
    // Method to reverse an ArrayList
    public static <T> void reverseArrayList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            // Swap elements
            T temp = list.get(left); //using temp varisble for swapping
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    // Method to reverse a LinkedList manually
    public static <T> LinkedList<T> reverseLinkedList(LinkedList<T> list) {
        LinkedList<T> reversedList = new LinkedList<>();//create new linked list for swapping
        for (T item : list) {
            reversedList.addFirst(item); // Add elements to the front
        }
        return reversedList;
    }

    public static void main(String[] args) {
        // ArrayList example
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + arrayList);
        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        // LinkedList example
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("\nOriginal LinkedList: " + linkedList);
        LinkedList<Integer> reversedLinkedList = reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}
