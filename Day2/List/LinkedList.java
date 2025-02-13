class LinkedList {
    Node head;
    
    // Node class to represent each element in the linked list
    static class Node {
        char data;
        Node next;
        
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to find the Nth element from the end of the list
    public char findNthFromEnd(int N) {
        Node first = head;
        Node second = head;
        
        // Move the first pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (first == null) {
                System.out.println("The list is shorter than N");
                return '\0';  // Return null character if N is greater than the list length
            }
            first = first.next;
        }
        
        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Now, second pointer is at the Nth node from the end
        return second.data;
    }

    // Function to add a node to the list
    public void add(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Add nodes to the list [A, B, C, D, E]
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');
        
        // Find the 2nd element from the end (Expected output: D)
        System.out.println("The 2nd element from the end is: " + list.findNthFromEnd(2));
    }
}
