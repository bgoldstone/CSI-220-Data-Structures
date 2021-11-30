import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tests the {@link AdjacencyList}
 */
public class Lab6Tester {
    static Scanner scan = new Scanner(System.in);
    static AdjacencyList list;

    public static void main(String[] args) {
        String prompt = """
                  Graph Tester Menu
                  1. Find the shortest path
                  2. DFS and BFS
                  3. Load new File
                  4. Exit
                Enter an Option(1,2,3,4): """;
        char choice = '0';
        while (choice != '4') {
            System.out.print(prompt);
            choice = scan.nextLine().charAt(0);
            System.out.println();
            switch (choice) {
                case '1':
                    findShortestPath();
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

    private static void displayDFSBFS() {
        //Checks if List is Empty
        if(list == null){
            System.out.println("List is Empty!");
            return;
        }
        //display DFS
        list.displayDFS();
        //display BFS
        list.displayBFS();

        boolean[] visisted = new boolean[list.getNumOfNodes()];
        for (boolean bool: visisted){
            System.out.println(bool);
        }
    }

    private static void findShortestPath() {
        //Checks if List is Empty
        if(list == null){
            System.out.println("List is Empty!");
            return;
        }
    }

    public static void loadFile() {

        Scanner file;
        System.out.print("What File would you like to read? ");
        String fileName = scan.nextLine();
        try {
            file = new Scanner(new File(fileName));
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("File Name: \"" + fileName + "\" is invalid!");
            return;
        }
        String[] firstLine = file.nextLine().split(" ");
        int numOfNodes = Integer.parseInt(firstLine[0]);
        int numOfEdges = Integer.parseInt(firstLine[1]);
        list = new AdjacencyList(numOfNodes);
        String[] current = new String[3];
        for (int i = 0; i < numOfEdges; i++) {
            current = scan.nextLine().split(" ");
            list.insert(Integer.parseInt(current[0]), Integer.parseInt(current[1]), Integer.parseInt(current[2]));
        }
        list.display();
    }
}
