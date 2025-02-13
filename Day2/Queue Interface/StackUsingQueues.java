import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push element x onto stack
    public void push(int x) {
        queue1.add(x);
    }

    // Removes the element on the top of the stack
    public int pop() {
        // Move all elements except the last to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        // The last element in queue1 is the top element
        int top = queue1.remove();
        
        // Swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return top;
    }

    // Get the top element
    public int top() {
        // Move all elements except the last to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        // The last element in queue1 is the top element
        int top = queue1.peek();
        
        // Move the element to queue2
        queue2.add(queue1.remove());
        
        // Swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return top;
    }

    // Check if the stack is empty
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        // Pop the top element (3)
        System.out.println(stack.pop()); // Output: 3
        
        // Get the top element (2)
        System.out.println(stack.top()); // Output: 2
        
        // Pop the top element (2)
        System.out.println(stack.pop()); // Output: 2
        
        // Check if the stack is empty (false)
        System.out.println(stack.empty()); // Output: false
    }
}
