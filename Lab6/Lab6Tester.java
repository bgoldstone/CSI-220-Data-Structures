import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tests the {@link MyAdjacencyList} and the use of Dijkstra's Algorithm, Breath
 * First Search, and Depth First Search.
 *
 * @author Ben Goldstone
 * @version 11/30/2021
 */
public class Lab6Tester {
    static Scanner scan = new Scanner(System.in);
    static MyAdjacencyList list;

    public static void main(String[] args) {
        list = new MyAdjacencyList(-1);
        String prompt = """
                  Graph Tester Menu
                  1. Find the shortest path
                  2. DFS and BFS
                  3. Load new File
                  4. Exit
                Enter an Option(1,2,3,4):\s""";
        char choice = '0';
        while (choice != '4') {
            System.out.print(prompt);
            choice = scan.nextLine().charAt(0);
            System.out.println();
            switch (choice) {
                case '1':
                    if (list.getNumberOfNodes() == -1) {
                        System.out.println("No list loaded!");
                        break;
                    }
                    try {
                        System.out.print("What node number would you like to start with? ");
                        int startNode = Integer.parseInt(scan.nextLine());
                        System.out.println();
                        list.findShortestPath(startNode);
                    } catch (NumberFormatException e) {
                        System.out.println("Data Type is not an Integer");
                    }
                    break;
                case '2':
                    displayDFSBFS();
                    break;
                case '3':
                    loadFile();
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }
    }

    /**
     * Displays DFS and BFS order.
     */
    private static void displayDFSBFS() {
        // Checks if List is Empty
        if (list == null) {
            System.out.println("List is Empty!");
            return;
        }
        // display DFS
        list.displayDFS();
        // display BFS
        list.displayBFS();
    }

    /**
     * Loads in a file of a graph into an AdjacencyList.
     */
    public static void loadFile() {

        Scanner file = null;
        boolean validFile = false;
        while (!validFile) {
            System.out.print("What File would you like to read? ");
            String fileName = scan.nextLine();
            try {
                file = new Scanner(new File(fileName));
                System.out.println();
                validFile = true;
            } catch (FileNotFoundException e) {
                System.out.println("File Name: \"" + fileName + "\" is invalid!");
                continue;
            }
            String[] firstLine = file.nextLine().split(" ");
            int numOfNodes = Integer.parseInt(firstLine[0]);
            int numOfEdges = Integer.parseInt(firstLine[1]);
            list = new MyAdjacencyList(numOfNodes);
            String[] current;
            for (int i = 0; i < numOfEdges; i++) {
                current = file.nextLine().split(" ");
                try {
                    list.insert(Integer.parseInt(current[0]), Integer.parseInt(current[1]),
                            Integer.parseInt(current[2]));
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("String index out of bounds!");
                }
            }
            list.display();
            file.close();

        }

    }
}
