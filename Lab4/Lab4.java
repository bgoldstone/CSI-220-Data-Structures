import java.util.Scanner;

public class Lab4 {
	static StringBuilder output = new StringBuilder();
	static Stack<String> stack = new Stack<>(10);
	static Scanner scan = new Scanner(System.in);

	// operators enum
	enum Operation {
		// ordinal
		None, // 0
		OpenParenthesis, // 1
		AddSubtract, // 2
		MultiplyDivideModulus, // 3
		CloseParenthesis; // 4
	}


	public static void main(String[] args) {
		char option = '0';
		while (option != '4') {
			System.out.print("""
					Please enter an option:\s
					1. Convert Infix to Postfix
					2. Convert Postfix to Infix
					3. Convert Postfix to Infix and evaluate
					4. Quit
					Enter Option (1,2,3,4):\s""");
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
                System.out.println(toInfixEvaluated());
			case '4':
				break;
			default:
				System.out.println("Invalid Option!");
				break;
			}
            System.out.println();
		}
	}

	public static String toInfix() {
		// clears StringBuilder & Stack
		output.setLength(0);
		stack.clear();
		// gets String from user
		System.out.print("Enter a string to convert to postfix: ");
		String input = scan.nextLine();
		System.out.println();
		for (Character currentValue : input.toCharArray()) {
            if (Character.isLetterOrDigit(currentValue)) {
                stack.push(String.valueOf(currentValue));
            } else if (currentValue.equals("(") || (currentValue.equals(")")))
                continue;
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
		return output.toString();
	}

    public static String toInfixEvaluated() {
        // clears StringBuilder & Stack
        output.setLength(0);
        stack.clear();
        // gets String from user
        System.out.print("Enter a string to convert to postfix: ");
        String input = scan.nextLine();
        System.out.println();
        for (Character currentValue : input.toCharArray()) {
            if(Character.isLetter(currentValue))
                return "Postfix to Infix and evaluation does not work with letters!";
            else if (Character.isDigit(currentValue)) {
                stack.push(String.valueOf(currentValue));
            } else if (currentValue.equals("(") || (currentValue.equals(")")))
                continue;
            else {
                String a = stack.pop();
                String b = String.valueOf(currentValue);
                String c = stack.pop();
                if(b.equals("*"))
                    stack.push(Integer.toString((Integer.parseInt(c) * Integer.parseInt(a))));
                else if(b.equals("/"))
                    stack.push(Integer.toString((Integer.parseInt(c) / Integer.parseInt(a))));
                else if(b.equals("+"))
                    stack.push(Integer.toString((Integer.parseInt(c) + Integer.parseInt(a))));
                else if(b.equals("-"))
                    stack.push(Integer.toString((Integer.parseInt(c) - Integer.parseInt(a))));
                else if(b.equals("%"))
                    stack.push(Integer.toString((Integer.parseInt(c) % Integer.parseInt(a))));
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return "The evaluated infix sequence is \"" + output.toString() + "\"";
    }

	public static String toPostfix() {
		// clears StringBuilder & Stack
		output.setLength(0);
		stack.clear();
		Operation currentOperator = Operation.None;
		Operation stackOperator = Operation.None;
		String stackValue;
		// gets String from user
		System.out.print("Enter a string to convert to infix: ");
		String input = scan.nextLine().replace(" ", "");
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
			if (!stack.isEmpty()) {
				stackValue = stack.peek();
				if (stackValue.equals('*') || stackValue.equals('/'))
					stackOperator = Operation.MultiplyDivideModulus;
				else if (stackValue.equals('+') || stackValue.equals('-'))
					stackOperator = Operation.AddSubtract;
				else if (stackValue.equals('(')) {
					stackOperator = Operation.OpenParenthesis;
				} else if (stackValue.equals(')'))
					stackOperator = Operation.CloseParenthesis;
				// if '(' add to stack
				if (currentOperator == Operation.OpenParenthesis) {
					stack.push(String.valueOf(currentValue));
					continue;
				}
				// else if ')' pop up to '('
				else if (currentValue == ')') {
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
				if (stackOperator.ordinal() < currentOperator.ordinal()) {
					stack.push(String.valueOf(currentValue));

				} else if ((stackOperator.ordinal() == currentOperator.ordinal())
						|| (stackOperator.ordinal() > currentOperator.ordinal())) {
					output.append(stack.pop());
					stack.push(String.valueOf(currentValue));
				}
				// else put operator in stack
			} else {
				stack.push(String.valueOf(currentValue));
			}

		}
		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}

		return output.toString();
	}
}
