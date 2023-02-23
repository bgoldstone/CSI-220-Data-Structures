
public class QueueExample {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(6);
    }

}

class Queue {
    int front;
    int rear;
    int size;
    int[] queue;
    public Queue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int val) {
        if(isEmpty() && !isFull())
            front++;
        if(!isFull()){
            queue[rear + 1 % size] = val;
        }else{
            System.out.println("List is full!");
        }
    }
    public int dequeue(){
        int returnVal =  rear;
        rear = rear - 1 % size;
        return returnVal;
    }
    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return front == rear;
    }


}