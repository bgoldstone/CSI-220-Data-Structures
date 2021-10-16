import java.util.Scanner;

public class Lab4 {
    static StringBuilder output = new StringBuilder();
    static Stack<Character> stack = new Stack<>(10);
    static Scanner scan = new Scanner(System.in);

    //operators enum
    enum Operation {
        None,
        OpenParenthesis,
        AddSubtract, MultiplyDivide,
        CloseParenthesis;
    }

    enum Hello {
        Hello, Goodbye, SeeYouSoon;
    }

    public static void main(String[] args) {
        char option = '0';
        while (option != '3') {
            System.out.print("""
                    Please enter an option:\s
                    1. Convert Infix to Postfix
                    2. Convert Postfix to Infix
                    3. Quit
                    Enter Option (1,2,3):\s""");
            option = scan.nextLine().charAt(0);
            System.out.println();
            switch (option) {
                case '1':
                    System.out.println("The postfix sequence is \"" + toPostfix() + "\"");
                    break;
                case '2':
                    System.out.println("The infix sequence is \"" + toInfix() + "\"");
                    break;
                case '3':
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }
    }

    public static String toInfix() {
        //clears StringBuilder & Stack
        output.setLength(0);
        stack.clear();
        //gets String from user
        System.out.print("Enter a string to convert to postfix: ");
        String input = scan.nextLine();
        System.out.println();

        return output.toString();
    }

    public static String toPostfix() {
        //clears StringBuilder & Stack
        output.setLength(0);
        stack.clear();
        Operation currentOperator = Operation.None;
        Operation stackOperator = Operation.None;
        Character stackValue;
        //gets String from user
        System.out.print("Enter a string to convert to infix: ");
        String input = scan.nextLine().replace(" ", "");
        for (Character currentValue : input.toCharArray()) {
            //Determines character
            //if is digit
            if (Character.isDigit(currentValue)) {
                output.append(currentValue);
                continue;
            }
            //else check what character it is
            else if (currentValue.equals('*') || currentValue.equals('/'))
                currentOperator = Operation.MultiplyDivide;
            else if (currentValue.equals('+') || currentValue.equals('-'))
                currentOperator = Operation.AddSubtract;
            else if (currentValue.equals('('))
                currentOperator = Operation.OpenParenthesis;
            else if (currentValue.equals(')'))
                currentOperator = Operation.CloseParenthesis;

            //check if operator stack is not empty and assigns value to character at the top of the stack.
            if (!stack.isEmpty()) {
                stackValue = stack.peek();
                if (stackValue.equals('*') || stackValue.equals('/'))
                    stackOperator = Operation.MultiplyDivide;
                else if (stackValue.equals('+') || stackValue.equals('-'))
                    stackOperator = Operation.AddSubtract;
                else if (stackValue.equals('(')) {
                    stackOperator = Operation.OpenParenthesis;
                } else if (stackValue.equals(')'))
                    stackOperator = Operation.CloseParenthesis;
                //if '(' add to stack
                if (currentOperator == Operation.OpenParenthesis) {
                    stack.push(currentValue);
                    continue;
                }
                //else if ')' pop up to '('
                else if (currentValue == ')') {
                    //inserts everything to the open parenthesis
                    while (stack.peek() != '(') {
                        if (stack.peek() == '(')
                            continue;
                        output.append(stack.pop());
                        if (stack.isEmpty())
                            break;
                    }
                    //removes closing parenthesis
                    stack.pop();
                    continue;
                }
                //AS 11, MD 10
                if (stackOperator.ordinal() < currentOperator.ordinal()) {
                    stack.push(currentValue);

                } else if ((stackOperator.ordinal() == currentOperator.ordinal()) || (stackOperator.ordinal() > currentOperator.ordinal())) {
                    output.append(stack.pop());
                    stack.push(currentValue);
                }
                //else put operator in stack
            } else {
                stack.push(currentValue);
            }

        }
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }
}
