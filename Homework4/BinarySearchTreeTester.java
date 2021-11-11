import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 * Tests the {@link BinarySearchTree} Objects.
 */
public class BinarySearchTreeTester {
    static Scanner scan;
    static BinarySearchTree<Integer> intTree;
    static BinarySearchTree<Character> charTree;
    static BinarySearchTree<Double> doubleTree;
    static String error = "Invalid Option!";
    static String invalidData = "Invalid Data Type!";
    static Random rand = new Random();

    /**
     * Main method. allows user to modify {@link BinarySearchTree}.
     *
     * @param args
     */
    public static void main(String[] args) {
        intTree = new BinarySearchTree<>();
        charTree = new BinarySearchTree<>();
        doubleTree = new BinarySearchTree<>();
        scan = new Scanner(System.in);

        char choice;
        while (true) {
            System.out.print("""
                    What would you like to do?
                    1. Insert an element
                    2. Delete an element
                    3. Find an element
                    4. Print List
                    5. Exit
                    Enter a choice (1,2,3,4,5):\s""");
            choice = scan.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    insertElement();
                    break;
                case '2':
                    deleteElement();
                    break;
                case '3':
                    findElement();
                    break;
                case '4':
                    System.out.print("""
                            What would you like to view?
                            1. Print preorder list
                            2. Print inorder list
                            3. Print postorder list
                            Enter a choice (1,2,3)\s""");
                    char type = scan.nextLine().charAt(0);
                    System.out.println("Integer Tree: ");
                    intTree.print(type);
                    System.out.println("Character Tree: ");
                    charTree.print(type);
                    System.out.println("Double Tree: ");
                    doubleTree.print(type);
                    break;
                case '5':
                    return;
                default:
                    System.out.println(error);


            }
        }
    }

    /**
     * Finds an element in a specific tree.
     */
    private static void findElement() {
        String isInTree = "Node is in the tree!";
        String isNotInTree = "Node is not in the tree!";
        System.out.print("""
                What type of value would you like to find?
                1. Find Integer
                2. Find Character
                3. Find Double
                Enter a choice (1,2,3):\s""");
        char choice = scan.nextLine().charAt(0);
        if (choice == '1' || choice == '2' || choice == '3')
            System.out.print("What value would you like to find? ");
        switch (choice) {
            case '1':
                if (intTree.findNode(scan.nextInt()))
                    System.out.println(isInTree);
                else
                    System.out.println(isNotInTree);
                scan.nextLine();
                break;
            case '2':
                if (charTree.findNode(scan.nextLine().charAt(0)))
                    System.out.println(isInTree);
                else
                    System.out.println(isNotInTree);
                break;

            case '3':
                if (doubleTree.findNode(scan.nextDouble()))
                    System.out.println(isInTree);
                else
                    System.out.println(isNotInTree);
                scan.nextLine();
                break;
            default:
                System.out.println(error);
        }


    }

    /**
     * Inserts an element of the list and sends them to either Insert_One or Insert10.
     */
    private static void insertElement() {
        char choice;
        System.out.print("""
                What would you like to do?
                1. Insert one element
                2. Insert ten random elements
                3. Return to main menu
                Enter a choice (1,2,3):\s""");
        choice = scan.nextLine().charAt(0);
        switch (choice) {
            case '1':
                Insert_One();
                break;
            case '2':
                Insert10();
                break;
            case '3':
                return;
            default:
                System.out.println(error);
                break;
        }
        System.out.println();
    }

    /**
     * inserts one of the users choice
     */
    private static void Insert_One() {
        char choice;
        System.out.print("""
                What would you like insert?
                1. Insert Integer
                2. Insert Character
                3. Insert Double
                4. Return to main menu
                Enter a choice (1,2,3,4):\s""");
        choice = scan.nextLine().charAt(0);
        //inserts based on user's choice
        String insertMessage = "\nWhat value would you like to insert? ";
        switch (choice) {
            case '1':
                System.out.print(insertMessage);
                try {
                    intTree.insert(scan.nextInt());
                } catch (InputMismatchException e) {
                    System.out.println(invalidData);
                }
                scan.nextLine();
                break;
            case '2':
                System.out.print(insertMessage);
                try {
                    charTree.insert(scan.nextLine().charAt(0));
                } catch (InputMismatchException e) {
                    System.out.println(invalidData);
                }
                break;
            case '3':
                System.out.print(insertMessage);
                try {
                    doubleTree.insert(scan.nextDouble());
                } catch (InputMismatchException e) {
                    System.out.println(invalidData);
                }
                scan.nextLine();
                break;
            case '4':
                return;
            default:
                System.out.println("Invalid insert option!");

        }
        System.out.println();
    }

    /**
     * inserts 10 random elements
     */
    private static void Insert10() {
        char choice;
        System.out.print("""
                What 10 values would you like insert?
                1. Insert Integer
                2. Insert Character
                3. Insert Double
                4. Return to main menu
                Enter a choice (1,2,3,4):\s""");
        choice = scan.nextLine().charAt(0);
        //inserts based on user's choice
        switch (choice) {
            case '1':
                for (int i = 0; i < 10; i++) {
                    intTree.insert(rand.nextInt(100));
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
                return;
            default:
                System.out.println(error);
                break;
        }
    }

    /**
     * deletes user given element
     */
    private static void deleteElement() {
        char choice;
        System.out.print("""
                What would you like delete?
                1. Delete integer
                2. Delete character
                3. Delete double
                4. Return to main menu
                Enter a choice (1,2,3,4):\s""");
        choice = scan.nextLine().charAt(0);
        String deleteMessage = "\nWhat value would you like to delete? ";
        //inserts based on user's choice
        switch (choice) {
            case '1':
                System.out.print(deleteMessage);
                try {
                    intTree.delete(scan.nextInt());
                } catch (InputMismatchException e) {
                    System.out.println(invalidData);
                }
                scan.nextLine();
                break;
            case '2':
                System.out.print(deleteMessage);
                try {
                    charTree.delete(scan.nextLine().charAt(0));
                } catch (InputMismatchException e) {
                    System.out.println(invalidData);
                }
                break;
            case '3':
                System.out.print(deleteMessage);
                try {
                    doubleTree.delete(scan.nextDouble());
                } catch (InputMismatchException e) {
                    System.out.println(invalidData);
                }
                scan.nextLine();
                break;
            case '4':
                return;
            default:
                System.out.println("Invalid delete option!");

        }
        System.out.println();
    }
}
