import java.util.Scanner;

/**
 * Converts a string of a mathematical expression from Postfix to Infix and from Infix to Postfix.
 */
public class Lab4 {
    static StringBuilder output = new StringBuilder();
    static Stack<String> stack = new Stack<>(10);
    static Scanner scan = new Scanner(System.in);

    /**
     * enum Operations. Used to convert character operator to an enum representation.
     */
    enum Operation {
        // ordinal
        None, // 0
        OpenParenthesis, // 1
        AddSubtract, // 2
        MultiplyDivideModulus, // 3
        CloseParenthesis // 4
    }

    public static void main(String[] args) {
        char option = '0';
        String input = "";
        while (option != '3') {
            System.out.print("""
                    Please enter an option:
                    1. Convert Infix to Postfix
                    2. Convert Postfix to Infix
                    3. Quit
                    Enter Option (1,2,3):\s""");
            try {
                option = scan.nextLine().charAt(0);
            } catch (StringIndexOutOfBoundsException E) {
                option = 0;
            }
            System.out.println();
            switch (option) {
                case '1':
                    System.out.print("Enter a string to convert to postfix: ");
                    input = scan.nextLine();
                    System.out.println();
                    System.out.println("The postfix sequence is \"" + toPostfix(input) + "\"");
                    break;
                case '2':
                    System.out.print("""
                            Enter an option:
                            1. Convert to Infix
                            2. Evaluate infix
                            Enter Option (1,2):\s""");
                    try {
                        option = scan.nextLine().charAt(0);
                    } catch (StringIndexOutOfBoundsException E) {
                        option = '0';
                    }
                    if (option == '1' || option == '2') {
                        System.out.print("Enter a string to convert to postfix: ");
                        input = scan.nextLine();
                        System.out.println();
                    }
                    if (option == '1') {
                        String returnValue = toInfix(input);
                        if (returnValue.equals("1")) {
                            System.out.println("Invalid Input!");
                        } else
                            System.out.println("The infix sequence is \"" + returnValue + "\"");
                    } else if (option == '2')
                        System.out.println(toInfixEvaluated(input));
                    else
                        System.out.println("Invalid Option!");
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

    /**
     * Converts from Postfix to Infix
     *
     * @return Infix representation.
     */
    public static String toInfix(String input) {
        // clears StringBuilder & Stack
        output.setLength(0);
        stack.clear();
        input = input.replace(" ", "");
        for (Character currentValue : input.toCharArray()) {
            if (Character.isLetterOrDigit(currentValue)) {
                stack.push(String.valueOf(currentValue));
            } else if (currentValue.equals('(') || (currentValue.equals(')')))
                System.out.println("Invalid Postfix!");
            else {
                String a = stack.pop();
                String b = String.valueOf(currentValue);
                String c = stack.pop();
                stack.push(c + b + a);
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        if (output.toString().contains("null")) {
            return "1";
        }
        return output.toString();
    }

    /**
     * Converts Postfix to Infix and evaluates the expression.
     *
     * @return a number that the postfix expression evaluates to.
     */
    public static String toInfixEvaluated(String input) {
        // clears StringBuilder & Stack
        output.setLength(0);
        stack.clear();
        input = input.replace(" ", "");
        for (Character currentValue : input.toCharArray()) {
            if (Character.isLetter(currentValue))
                return "Postfix to Infix and evaluation does not work with letters!";
            else if (Character.isDigit(currentValue)) {
                stack.push(String.valueOf(currentValue));
            } else {
                String a = stack.pop();
                String b = String.valueOf(currentValue);
                String c = stack.pop();
                switch (b) {
                    case "*" -> stack.push(Integer.toString((Integer.parseInt(c) * Integer.parseInt(a))));
                    case "/" -> stack.push(Integer.toString((Integer.parseInt(c) / Integer.parseInt(a))));
                    case "+" -> stack.push(Integer.toString((Integer.parseInt(c) + Integer.parseInt(a))));
                    case "-" -> stack.push(Integer.toString((Integer.parseInt(c) - Integer.parseInt(a))));
                    case "%" -> stack.push(Integer.toString((Integer.parseInt(c) % Integer.parseInt(a))));
                }
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return "The evaluated infix sequence is \"" + output.toString() + "\"";
    }

    /**
     * Converts Infix to Postfix
     *
     * @return Postfix representation.
     */
    public static String toPostfix(String input) {
        // clears StringBuilder & Stack
        output.setLength(0);
        stack.clear();
        Operation currentOperator = Operation.None;
        Operation stackOperator;
        input = input.replace(" ", "");
        for (Character currentValue : input.toCharArray()) {
            // Determines character
            // if is digit
            if (Character.isLetterOrDigit(currentValue)) {
                output.append(currentValue);
                continue;
            }
            // else check what character it is
            else if (currentValue.equals('*') || currentValue.equals('/') || currentValue.equals('%'))
                currentOperator = Operation.MultiplyDivideModulus;
            else if (currentValue.equals('+') || currentValue.equals('-'))
                currentOperator = Operation.AddSubtract;
            else if (currentValue.equals('('))
                currentOperator = Operation.OpenParenthesis;
            else if (currentValue.equals(')'))
                currentOperator = Operation.CloseParenthesis;

            // check if operator stack is not empty and assigns value to character at the
            // top of the stack.
            // System.out.println(stack.isEmpty());
            if (!stack.isEmpty()) {
                stackOperator = getStackOperator();
                // if '(' add to stack
                if (currentOperator == Operation.OpenParenthesis) {
                    stack.push(String.valueOf(currentValue));
                    continue;
                    // else if ')' pop up to '('
                } else if (currentValue == ')') {
                    // inserts everything to the open parenthesis
                    while (!stack.peek().equals("(")) {
                        output.append(stack.pop());
                        if (stack.isEmpty())
                            break;
                    }
                    // removes closing parenthesis
                    stack.pop();
                    continue;
                }
                if (stackOperator.ordinal() >= currentOperator.ordinal()) {
                    while (((stackOperator.ordinal() == currentOperator.ordinal())
                            || (stackOperator.ordinal() > currentOperator.ordinal()))) {
                        output.append(stack.pop());
                        if (stack.isEmpty())
                            break;
                        else
                            stackOperator = getStackOperator();
                    }
                }
                // else put operator in stack
            }
            stack.push(String.valueOf(currentValue));

        }
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }

    /**
     * Gets the stack operator.
     *
     * @return current enum representation of the Operator at the top of the stack.
     */
    public static Operation getStackOperator() {
        return switch (stack.peek()) {
            case "*", "/" -> Operation.MultiplyDivideModulus;
            case "+", "-" -> Operation.AddSubtract;
            case "(" -> Operation.OpenParenthesis;
            case ")" -> Operation.CloseParenthesis;
            default -> Operation.None;
        };
    }
}
