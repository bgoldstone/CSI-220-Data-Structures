import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class BinarySearchTreeTester {
    static Scanner scan;
    static BinarySearchTree<Integer> intTree;
    static BinarySearchTree<Character> charTree;
    static BinarySearchTree<Double> doubleTree;


    public static void main(String[] args) {
        intTree = new BinarySearchTree<>();
        charTree = new BinarySearchTree<>();
        doubleTree = new BinarySearchTree<>();
        scan = new Scanner(System.in);

        char choice = '0';
        while (choice != '5') {
            System.out.print("""
                    What would you like to do?
                    1. Insert an element
                    2. Delete an element
                    3. Find an element
                    4. Print List
                    5. Exit
                    Enter a choice (1,2,3,4,5): """);
            choice = scan.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    insertElement();
                    System.out.println("Element successfully added");
                    break;
                case '2':
                    deleteElement();
                    break;
                case '3':
                    break;
                case '4':
                    break;
                case '5':
                    System.out.print("""
                            What would you like to view?
                            1. Print preorder list
                            2. Print inorder list
                            3. Print postorder list
                            Enter a choice (1,2,3): """);
                    char type = scan.nextLine().charAt(0);
                    System.out.println("Integer Tree: ");
                    intTree.print(type);
                    System.out.println("Character Tree: ");
                    charTree.print(type);
                    System.out.println("Double Tree: ");
                    doubleTree.print(type);

                    break;
                default:
                    System.out.println("Invalid Option!");


            }
        }
    }

    //insert method
    private static void insertElement() {
        char choice = '0';
        while (choice != '3') {
            System.out.print("""
                    What would you like to do?
                    1. Insert one element
                    2. Insert ten random element
                    3. Return to main menu
                    Enter a choice (1,2,3): """);
            choice = scan.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    Insert_One();
                    break;
                case '2':
                    Insert10();
                    break;
                case '3':
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
            System.out.println();
        }
    }

    //inserts one of the users choice
    private static void Insert_One() {
        char choice = '0';
        while (choice != '4') {
            System.out.print("""
                    What would you like insert?
                    1. Insert Integer
                    2. Insert Character
                    3. Insert Double
                    4. Return to main menu
                    Enter a choice (1,2,3,4): """);
            choice = scan.nextLine().charAt(0);
            //inserts based on user's choice
            switch (choice) {
                case '1':
                    System.out.print("\nWhat value would you like to insert? ");
                    try {
                        intTree.insert(scan.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Data Type!");
                    }
                    scan.nextLine();
                    break;
                case '2':
                    System.out.print("\nWhat value would you like to insert? ");
                    try {
                        charTree.insert(scan.nextLine().charAt(0));
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Data Type!");
                    }
                    break;
                case '3':
                    System.out.print("\nWhat value would you like to insert? ");
                    try {
                        doubleTree.insert(scan.nextDouble());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Data Type!");
                    }
                    scan.nextLine();
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Invalid insert option!");

            }
            System.out.println();
        }
    }

    //inserts 10 random elements
    private static void Insert10() {
        Random rand = new Random();
        char choice = 0;
        while (choice != 4) {
            System.out.print("""
                    What 10 values would you like insert?
                    1. Insert Integer
                    2. Insert Character
                    3. Insert Double
                    4. Return to main menu
                    Enter a choice (1,2,3,4): """);
            choice = scan.nextLine().charAt(0);
            //inserts based on user's choice
            switch (choice) {
                case '1':
                    for (int i = 0; i < 10; i++) {
                        intTree.insert(rand.nextInt());
                    }
                    break;
                case '2':
                    for (int i = 0; i < 10; i++) {
                        charTree.insert((char) (rand.nextInt(94) + 32));
                    }
                    break;
                case '3':
                    for (int i = 0; i < 10; i++) {
                        doubleTree.insert(rand.nextDouble() + 100);
                    }
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }
    }

    //deletes user given element
    private static void deleteElement() {
        char choice = '0';
        while (choice != '4') {
            System.out.print("""
                    What would you like delete?
                    1. Delete integer
                    2. Delete character
                    3. Delete double
                    4. Return to main menu
                    Enter a choice (1,2,3,4): """);
            choice = scan.nextLine().charAt(0);
            //inserts based on user's choice
            switch (choice) {
                case '1':
                    System.out.print("\nWhat value would you like to delete? ");
                    try {
                        if(intTree.delete(scan.nextInt()))
                            System.out.println("Element successfully removed.");
                        else
                            System.out.println("Element could not be removed.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Data Type!");
                    }
                    scan.nextLine();
                    break;
                case '2':
                    System.out.print("\nWhat value would you like to delete? ");
                    try {
                        if(charTree.delete(scan.nextLine().charAt(0)))
                            System.out.println("Element successfully removed.");
                        else
                            System.out.println("Element could not be removed.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Data Type!");
                    }
                    break;
                case '3':
                    System.out.print("\nWhat value would you like to delete? ");
                    try {
                        if(doubleTree.delete(scan.nextDouble()))
                            System.out.println("Element successfully removed.");
                        else
                            System.out.println("Element could not be removed.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Data Type!");
                    }
                    scan.nextLine();
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Invalid insert option!");

            }
            System.out.println();
        }
    }
}
