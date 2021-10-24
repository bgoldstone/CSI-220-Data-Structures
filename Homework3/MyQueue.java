import java.util.Arrays;

public class MyQueue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public MyQueue(int mySize) {
        this.size = mySize;
        this.queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int val) {
        if (isEmpty()) {
            front++;
        }
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % size;
        queue[rear] = val;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int returnValue = queue[front];
        queue[front] = 0;
        front = front + 1 % size;
        System.out.println(rear);
        System.out.println(front);
        return returnValue;

    }

    public boolean isEmpty() {
        return Arrays.compare(queue, new int[size]) == 0;
    }

    public boolean isFull() {
        if (isEmpty()) return false;
        return (rear + 1) % size == front;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i : queue) {
            sb.append(i).append(", ");
        }
        sb.append("]\n");
        return sb.toString();
    }
}
