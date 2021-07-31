
public class Operation {

	Stack stack = new Stack(25);
	Stack temp = new Stack(25);
	String[] operators = { "+", "-", "*", "/", "(", ")" };
	String postfix = "";

	public void infixToPostfix(String infix, boolean printSteps) {

		postfix = "";

		while (infix.length() > 0) {

			String operand;
			String operator;
			boolean operation;
			boolean notOperator = true;

			for (int i = 0; i < operators.length; i++) {
				if (operators[i].equals(infix.substring(0, 1)))
					notOperator = false;
			}

			if (notOperator) {
				do {
					operand = infix.substring(0, 1);
					postfix = postfix + operand;
					infix = infix.substring(1);
					for (int i = 0; i < operators.length; i++) {
						if (!infix.isEmpty() && operators[i].equals(infix.substring(0, 1)))
							notOperator = false;
					}
				} while (notOperator && !infix.isEmpty());
				if (printSteps)
					printStack();
			} else if (operators[4].equals(infix.substring(0, 1))) {
				stack.Push(infix.substring(0, 1));
				infix = infix.substring(1);
			} else if (operators[5].equals(infix.substring(0, 1))) {
				while (!stack.Peek().equals("(")) {
					postfix = postfix + " " + stack.Pop();
					if (printSteps) {
						System.out.println(postfix);
						printStack();
					}

				}
				stack.Pop();
				infix = infix.substring(1);
			} else {
				operator = infix.substring(0, 1);

				if (!stack.isEmpty()) {
					do {
						operation = true;
						if ((operator.equals("*") || operator.equals("/"))
								&& (stack.Peek().equals("+") || stack.Peek().equals("-")))
							operation = false;
						else if (stack.Peek().equals("("))
							operation = false;
						if (operation == true) {
							postfix = postfix + " " + stack.Pop();

							if (printSteps) {
								printStack();
								System.out.println(postfix);
							}
						}

					} while (operation && !stack.isEmpty());
				}
				stack.Push(operator);
				System.out.println(postfix + "\t\t\t");
				if (printSteps)
					printStack();
				infix = infix.substring(1);
				postfix += " ";
			}
		}

		while (!stack.isEmpty()) {
			postfix = postfix + " " + stack.Pop();
		}

		if (printSteps)
			System.out.println(postfix);
	}

	public String toString() {
		return postfix;
	}

	public void printStack() {

		System.out.println();
		while (!stack.isEmpty()) {

			System.out.println("| " + stack.Peek() + " |");
			temp.Push(stack.Pop());

		}
		System.out.println("-----");
		while (!temp.isEmpty()) {
			stack.Push(temp.Pop());
		}
		System.out.println();

	}

	public int postfixEvaluation(String expressionString, Boolean printSteps) throws Exception {
		/*
		 * This function evaluates the postfix expression.
		 */

		Stack postfix = new Stack(20);

		String[] expression = expressionString.split(" ");
		if(printSteps) {
			System.out.println("Postfix expression: " + expressionString);
			System.out.println("-------------------------");
		}
			
		for (int i = 0; i < expression.length; i++) { // for begin

			// if the character is a number, push it into the stack.
			if (!("+-*/".contains(expression[i]))) {
				postfix.Push(expression[i]);
			}
			// if it's an operator,
			// pop 2 integers and apply the operator,
			// then push the result into the stack.
			else if (postfix.Size() >= 2) {

				if (printSteps)
					showPostFixEvalStep(postfix);
				//
				int firstOperand = Integer.valueOf(String.valueOf(postfix.Peek()));
				postfix.Pop();
				int secondOperand = Integer.valueOf(String.valueOf(postfix.Peek()));
				postfix.Pop();
				//

				//
				if (expression[i].equals("+"))
					postfix.Push(secondOperand + firstOperand);
				else if (expression[i].equals("-"))
					postfix.Push(secondOperand - firstOperand);
				else if (expression[i].equals("*"))
					postfix.Push(secondOperand * firstOperand);
				else if (expression[i].equals("/"))
					postfix.Push(secondOperand / firstOperand);
				//

				if (printSteps)
					showPostFixEvalStep(postfix);
			}

		} // for end
		System.out.println("-------------------------");

		// return the result
		return (Integer) postfix.Pop();

	}

	public void showPostFixEvalStep(Stack stack) {

		/*
		 * This function prints one step of the function game.postfixEvaluation().
		 */

		Stack temp = new Stack(stack.Size());

		System.out.println();
		while (!stack.isEmpty()) {
			if (Integer.valueOf(String.valueOf(stack.Peek())) / 10 > 0) {
				System.out.println("| " + stack.Peek() + " |");
			}
			
			else
				System.out.println("| " + stack.Peek() + "  |");
			temp.Push(stack.Pop());

		}
		System.out.println("------");
		while (!temp.isEmpty()) {
			stack.Push(temp.Pop());
		}
		System.out.println();

	}

}
