import java.util.Scanner;

public class Answer {

	private String infix;
	private int result;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Boolean inputControl(int[] numbers) {

		// Takes the numbers in the input string to an integer array
		String tempInput = infix;
		tempInput = tempInput.replace('+', '@').replace('-', '@').replace('*', '@').replace('/', '@').replace('(', '@')
				.replace(')', '@');
		String[] inputTemp = tempInput.split("@");
		int[] inputValues = new int[100];
		int counter = 0;

		for (int i = 0; i < inputTemp.length; i++) {
			if (!inputTemp[i].isEmpty()) {
				inputValues[counter] = Integer.valueOf(inputTemp[i]);
				counter++;
			}

		}

		Boolean valid = true;

		for (int i = 0; i < counter; i++) {

			int counter1 = 0;
			int counter2 = 0;
			for (int j = 0; j < counter; j++) {

				if (inputValues[i] == inputValues[j])
					counter1++;

			}

			for (int k = 0; k < numbers.length; k++) {

				if (inputValues[i] == numbers[k])
					counter2++;

			}
			if (counter1 > counter2) {
				valid = false;
				break;
			}
		}
		return valid;
	}

	public void takeInput() {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter player's solution: ");
		this.infix = input.next();
		System.out.println();
		input.close();

	}

	public void takeResult(ComputerAnswer calculate) {
		Scanner ans = new Scanner(System.in);
		System.out.print("Answer : ");
		int answer = ans.nextInt();
		result = answer;
		System.out.println();
		System.out.println("Result Numbers");
		System.out.print("Player : " + answer);
		System.out.print("      ");
		System.out.print("Computer : " + calculate.getLastResult());
		System.out.println();
		ans.close();
	}

	public String getInfix() {
		return infix;
	}

	public void setInfix(String infix) {
		this.infix = infix;
	}

}
