import java.util.*;

public class ListRotation {
    public static <T> List<T> rotateList(List<T> list, int positions) {
        int n = list.size();
        positions = positions % n; // Handle cases where positions > list size

        // Split and rotate the list
        List<T> rotatedList = new ArrayList<>();
        rotatedList.addAll(list.subList(positions, n)); // Elements from positions to end
        rotatedList.addAll(list.subList(0, positions)); // Elements from start to positions

        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        List<Integer> rotated = rotateList(numbers, rotateBy);
        System.out.println(rotated); // Output: [30, 40, 50, 10, 20]
    }
}
