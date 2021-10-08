import java.util.Scanner;

public class TesterSortedDoubleList {
    public static void main(String args[]) throws Exception {
        SortedDoubleList list;
        String input = "0";
        String value = "";
        String type;
        String choice = "0";
        int count = 0;
        Scanner scan = new Scanner(System.in);
        while (!(input.equals("1") || input.equals("2"))) {
            System.out.println("Welcome to the LinkedList Tester!");
            System.out.println("Choose a list type:\n1. String\n2. Integer");
            System.out.print("Enter value: ");
            input = scan.nextLine();
            if (!((input.equals("1") || input.equals("2")))) {
                System.out.println("Invalid choice! Please choose 1 or 2.\n");
            }
        }
        if (input.equals("1")) {
            list = new SortedDoubleList<String>();
            type = "String";
        } else {
            list = new SortedDoubleList<Integer>();
            type = "Integer";
        }
        while (!choice.equals("10")) {
            System.out.println();
            System.out.println("Please select an option:\n");
            System.out.println("1. Insert element");
            System.out.println("2. Print list size");
            System.out.println("3. Is the list empty?");
            System.out.println("4. Print first element");
            System.out.println("5. Print last element");
            System.out.println("6. Count elements with a particular value");
            System.out.println("7. Remove first");
            System.out.println("8. Remove last");
            System.out.println("9. Remove elements with a particular value");
            System.out.print("10. Quit\n\nEnter value:");
            choice = scan.nextLine();
            System.out.println();
            if (isDigit(choice)) {
                switch (choice) {
                    case "1":
                        System.out.print("What " + type + " would you like to add: ");
                        value = scan.nextLine();
                        if (isDigit(value) && type.equals("Integer"))
                            list.insert(Integer.parseInt(value));
                        else {
                            list.insert(value);
                        }
                        break;

                    case "2":
                        System.out.println(list.size());
                        break;

                    case "3":
                        if (list.empty()) {
                            System.out.println("List is empty");
                        } else {
                            System.out.println("List is not empty");
                        }
                        break;

                    case "4":
                        String front = list.front().toString();
                        if (front != null) {
                            System.out.println("The first element is " + front);
                        } else {
                            System.out.println("The list is empty. there is no first element.");
                        }
                        break;

                    case "5":
                        String back = list.front().toString();
                        if (back != null) {
                            System.out.println("The last element is " + back);
                        } else {
                            System.out.println("The list is empty. there is no last element.");
                        }
                        break;
                    case "6":
                        System.out.print("What " + type + " would you like to count: ");
                        value = scan.nextLine();
                        if (isDigit(value) && type.equals("Integer"))
                            count = list.count(Integer.parseInt(value));
                        else {
                            count = list.count(value);
                        }
                        System.out.println("The value " + value + " occurs " + count + " times.");
                        break;

                    case "7":
                        value = list.pop_front().toString();
                        if (value != null)
                            System.out.println("Value " + value + " removed from the front of the list.");
                        else {
                            System.out.println("No value is removed because the list is empty.");
                        }
                        break;

                    case "8":
                        value = list.pop_back().toString();
                        if (value != null)
                            System.out.println("Value " + value + " removed from the end of the list.");
                        else {
                            System.out.println("No value is removed because the list is empty.");
                        }
                        break;

                    case "9":
                        System.out.print("What value do you want to remove? ");
                        value = scan.nextLine();
                        if (isDigit(value) && type.equals("Integer")) {
                            count = list.erase(Integer.parseInt(value));
                            System.out.println("The value " + value + " was removed " + count + " times!");
                        } else {
                            count = list.erase(value);
                            System.out.println("The value " + value + " was removed " + count + " times!");
                        }
                        break;
                    case "10":
                        break;
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
            }
        }

    }

    public static boolean isDigit(String input) {
        //Good way to do things
        if (input.matches("-?(0|[1-9]\\d*)")) {
            return true;
        } else {
            return false;
        }
    }
}
