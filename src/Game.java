import java.util.Scanner;

import enigma.core.Enigma;

public class Game {

	Scanner scan = new Scanner(System.in);
	ComputerAnswer calculate;

	static enigma.console.Console cn = Enigma.getConsole("NUMBERS", 100, 30, 20, 5);

	Operation operation = new Operation();
	Answer answer = new Answer();
	int targetRange;

	static int playerScore = 0;
	static int computerScore = 0;
	int point = 0;

	Game() throws Exception {

		difficultySelection();

		while (playerScore < 100 && computerScore < 100) {

			Question question = new Question();
			printGameScreen(question);
			answer.takeResult(calculate);

			
			
			// player's result is closer to target number
			if (Math.abs(answer.getResult() - question.getTargetNumber()) <= Math.abs(calculate.getLastResult() - question.getTargetNumber())) {
				answer.takeInput();
				operation.infixToPostfix(answer.getInfix(), false);
				
				
				if (answer.inputControl(question.getRandomNumbers()) && answer.getResult() == operation.postfixEvaluation(operation.toString(), false)) {
					operation.infixToPostfix(answer.getInfix(), true);
					operation.postfixEvaluation(operation.toString(),true);
				}

				if (Math.abs(answer.getResult() - question.getTargetNumber()) <= 10)
					point = 15 - Abs(answer.getResult() - question.getTargetNumber());
				else
					point = 5;
				if(answer.getResult() != operation.postfixEvaluation(operation.toString(), false))
					System.out.println("Your result doesn't match your input value.");
				else
				playerScore += point;

			}
			// computer's result is closer target number
			else {

				calculate.printSolutionSteps();

				if (Math.abs(calculate.getLastResult() - question.getTargetNumber()) <= 10)
					point = 15 - Abs(calculate.getLastResult() - question.getTargetNumber());
				else
					point = 5;

				computerScore += point;

			}

			System.out.println("Player Score : " + playerScore);
			System.out.println("Computer Score : " + computerScore);
			String str = scan.nextLine();
		}

		if (playerScore > computerScore)
			System.out.println("Player Win!");
		else if (playerScore < computerScore)
			System.out.println("Computer Win!");
		else
			System.out.println("It's a draw!");

	}

	private int Abs(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void difficultySelection() {

		Scanner difficultyInput = new Scanner(System.in);

		System.out.println("Select difficulty: ");
		System.out.println("1. Easy");
		System.out.println("2. Medium");
		System.out.println("3. Hard");

		String answer = " ";

		while (!"123".contains(answer)) {
			answer = difficultyInput.next();
			if ("123".contains(answer)) {
				if (answer.equals("1"))
					targetRange = 20;
				else if (answer.equals("2"))
					targetRange = 10;
				else
					targetRange = 1;
			} else
				System.out.println("Wrong input, please try again.");
		}

		difficultyInput.close();
	}

	public void printGameScreen(Question question) {

		calculate = new ComputerAnswer();

		System.out.println("-------------------------------------- Round " + ++Question.round
				+ " --------------------------------------------");

		System.out.println("Target Number : " + question.getTargetNumber());

		System.out.print("Numbers: ");
		for (int i = 0; i < 6; i++) {
			System.out.print(question.getRandomNumbers()[i] + " ");
		}
		System.out.println();

		System.out.print("Duration: ");
		calculateDuringTime(calculate, question);

		System.out.println(
				"--------------------------------------------------------------------------------------------");

	}

	public void calculateDuringTime(ComputerAnswer calculate, Question question) {
		int countdown = 30;
		int count = 0;
		long time1 = 0;
		long time2 = System.currentTimeMillis();
		boolean flag = true;

		do {
			time1 = System.currentTimeMillis();

			if (flag) {
				calculate.ComputerAnswer(question);
				count++;
				if (Math.abs(calculate.getLastResult() - question.getTargetNumber()) < targetRange)
					flag = false;
			}

			if (time1 - time2 >= 100) {
				System.out.print(countdown-- + " ");

				time2 = time1;
			}

		} while (countdown >= 0);
		System.out.println("\n");

	}

}