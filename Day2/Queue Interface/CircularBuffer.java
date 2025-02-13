public class CircularBuffer {
    private int[] buffer;
    private int front;
    private int rear;
    private int size;
    private int count;

    // Constructor to initialize the buffer with a fixed size
    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    // Insert an element into the buffer
    public void insert(int value) {
        if (count == size) {
            // Buffer is full, overwrite the oldest element
            front = (front + 1) % size;  // Move front pointer to the next element
        } else {
            count++;
        }

        // Insert the new element at the rear position
        buffer[rear] = value;

        // Move the rear pointer forward
        rear = (rear + 1) % size;
    }

    // Print the buffer elements
    public void printBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % size;
            System.out.print(buffer[index]);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);  // Buffer size 3

        // Insert elements
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);

        // Print the buffer after inserting 1, 2, 3
        buffer.printBuffer();  // Output: Buffer: [1, 2, 3]

        // Insert 4, this will overwrite the oldest element (1)
        buffer.insert(4);

        // Print the buffer after inserting 4
        buffer.printBuffer();  // Output: Buffer: [2, 3, 4]
    }
}
