import java.util.Arrays;

/**
 * A Circular Implementation of a Queue
 *
 * @author Ben Goldstone
 * @version 11/2/2021
 */
public class MyQueue {
    private int[] queue;
    private int[] compare;
    private int size;
    private int front;
    private int rear;

    /**
     * Queue constructor
     *
     * @param mySize size of queue
     */
    public MyQueue(int mySize) {
        this.size = mySize;
        this.queue = new int[size];
        this.compare = new int[size];
        front = -1;
        rear = -1;
        for (int i = 0; i < size; i++) {
            queue[i] = -1;
            compare[i] = -1;

        }
    }

    /**
     * inserts an item in a queue
     *
     * @param val value to insert into the queue
     */
    public void enqueue(int val) {
        if (isEmpty() && front == -1) {
            front++;
        }
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % size;
        queue[rear] = val;
    }

    /**
     * removes first value from the queue
     *
     * @return the first value in the queue
     */
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int returnValue = queue[front];
        queue[front] = -1;
        front = (front + 1) % size;
        return returnValue;

    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if queue is empty.
     */
    public boolean isEmpty() {
        return (Arrays.compare(queue, compare) == 0);
    }

    /**
     * Checks if queue is full.
     *
     * @return true if queue is full.
     */
    public boolean isFull() {
        if (isEmpty()) return false;
        return (rear + 1) % size == front;
    }

    /**
     * Returns string representation of a queue.
     * Mostly used for debugging purposes.
     *
     * @return String representation of Queue.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < queue.length; i++) {
            if (i + 1 == queue.length)
                sb.append(queue[i]);
            else
                sb.append(queue[i]).append(", ");
        }
        sb.append("]\n");
        return sb.toString();
    }
}
