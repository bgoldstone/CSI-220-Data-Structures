import java.util.Scanner;

/**
 * A program to test the {@link MyQueue} object.
 * @author Ben Goldstone
 * @version 11/2/2021
 */
public class TestQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        MyQueue queue = new MyQueue(5);
        while (option != 5) {
            System.out.print("""
                    Please enter an option:
                    1. enqueue
                    2. dequeue
                    3. isEmpty
                    4. isFull
                    5. Quit
                    Enter Option (1,2,3,4,5):\s""");
            option = scan.nextInt();
            scan.nextLine();
            System.out.println();
            switch (option) {
                case 1:
                    System.out.print("Enter a number to insert into the queue: ");
                    queue.enqueue(scan.nextInt());
                    scan.nextLine();
                    System.out.println(queue);
                    break;
                case 2:
                    System.out.println("Dequeued a \"" + queue.dequeue() + "\".");
                    System.out.println(queue);
                    break;
                case 3:
                    System.out.println(queue.isEmpty());
                    break;
                case 4:
                    System.out.println(queue.isFull());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
            System.out.println();
        }
    }
}
