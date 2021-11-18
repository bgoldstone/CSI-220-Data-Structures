import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab5Tester {
    static Scanner scan;
    static MinHeap heap;
    static OpenHashTable hashTable;

    public static void main(String[] args) {
        heap = new MinHeap(20);
        hashTable = new OpenHashTable(10);
        scan = new Scanner(System.in);
        char dataStructure = '0';
        while (dataStructure != '3') {
            System.out.print("Please Choose a data structure: \n1. Hash\n2. Heap\n3. Exit\nEnter (1,2,3)");
            dataStructure = scan.nextLine().charAt(0);
            System.out.println();
            switch (dataStructure) {
                case '1':
                    hashMenu();
                    break;
                case '2':
                    heapMenu();
                    break;
                case '3':
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;

            }
        }
    }

    private static void hashMenu() {
        char choice = '0';
        String key;
        String value;
        while (choice != '5') {
            System.out.print("\nWhat would you like to do?\n\t1. Search\n\t2. Insert\n\t3. Remove\n\t4. Display\n\t5. Return\nEnter an option(1,2,3,4,5): ");
            choice = scan.nextLine().charAt(0);
            System.out.println();

            switch (choice) {
                case '1':
                    System.out.print("What key would you like to search for? ");
                    key = scan.nextLine();
                    String returnValue = hashTable.search(key);
                    if (!returnValue.equals(""))
                        System.out.println("The key " + key + " is in the OpenHashTable with the value " + returnValue);
                    else
                        System.out.println("The key " + key + "is not in the OpenHashTable");
                    break;
                case '2':
                    System.out.print("What key would you like to insert? ");
                    key = scan.nextLine();
                    System.out.print("\nWhat value would you like to insert? ");
                    value = scan.nextLine();
                    System.out.println();
                    hashTable.insert(key, value);
                    break;
                case '3':
                    System.out.print("What key would you like to remove? ");
                    key = scan.nextLine();
                    System.out.println();
                    if (hashTable.remove(key))
                        System.out.println("Key " + key + " successfully removed!");
                    else
                        System.out.println("Key " + key + " was not found!");
                    break;
                case '4':
                    hashTable.display();
                    break;
                case '5':
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;


            }

        }
    }

    private static void heapMenu() {
        char choice = '0';
        String name;
        int priority;
        while (choice != '5') {
            System.out.print("\nWhat would you like to do?\n\t1. Search by name\n\t2. Insert new element\n\t3. Remove next guest\n\t4. Display all names and their ranking\n\t5. Return\nEnter an option(1,2,3,4,5): ");
            choice = scan.nextLine().charAt(0);
            System.out.println();

            switch (choice) {
                case '1':
                    System.out.print("What Guest would you like to search for?");
                    heap.search(scan.nextLine());
                    System.out.println();
                    break;
                case '2':
                    System.out.print("What is the name of the guest you would like to insert? ");
                    name = scan.nextLine();
                    System.out.print("\nWhat is the rank of " + name + "? ");
                    try {
                        priority = scan.nextInt();
                        scan.nextLine();
                        heap.insert(priority, name);
                        System.out.println("Guest " + name + " successfully inserted!");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid value! Must be integer, please try again.");
                        System.out.println("Guest " + name + " could not be inserted!");
                    }
                    break;
                case '3':
                    if (!heap.remove())
                        System.out.println("Heap is Empty!");
                    break;
                case '4':
                    heap.display();
                    break;
                case '5':
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }

    }
}
