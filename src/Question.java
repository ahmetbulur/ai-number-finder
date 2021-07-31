import java.util.Random;

public class Question {

	Random rnd = new Random();
	private int targetNumber;
	private int[] randomNumbers = new int[6];
	static int round = 0;

	public Question() {

		targetNumber = rnd.nextInt(899) + 100;
		for (int i = 0; i < randomNumbers.length - 1; i++) {
			randomNumbers[i] = rnd.nextInt(8) + 1;
		}
		randomNumbers[5] = (rnd.nextInt(4) + 1) * 25;
	}

	public int getTargetNumber() {
		return targetNumber;
	}

	public void setTargetNumber(int targetNumber) {
		this.targetNumber = targetNumber;
	}

	public int[] getRandomNumbers() {
		return randomNumbers;
	}

	public void setRandomNumbers(int[] randomNumbers) {
		this.randomNumbers = randomNumbers;
	}

	public void time() {
		int countdown = 30;
		long time1 = 0;
		long time2 = System.currentTimeMillis();

		do {
			time1 = System.currentTimeMillis();

			if (time1 - time2 >= 10) {
				System.out.print(countdown-- + " ");

				time2 = time1;
			}

		} while (countdown >= 0);
		System.out.println("\n");

	}
	public void printGameScreen() {

		System.out.println("-------------------------------------- Round " + ++Question.round
				+ " --------------------------------------------");

		System.out.println("Target Number : " + getTargetNumber());

		System.out.print("Numbers: ");
		for (int i = 0; i < 6; i++) {
			System.out.print(getRandomNumbers()[i] + " ");
		}
		System.out.println();

		System.out.print("Duration: ");
		time();

		System.out.println(
				"--------------------------------------------------------------------------------------------");

	}

}
