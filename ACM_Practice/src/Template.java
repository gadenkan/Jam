import java.util.Scanner;

class Template {
	private static String[] result;
	private static int noOfCases;
	private static int[] input;

	public static void main(String[] args) {

		readStdInput();
		calculate();
	}

	private static void readStdInput() {
		try {
			Scanner in = new Scanner(System.in);
			//System.out.print("Enter the number of test cases: ");
			noOfCases = in.nextInt();

			if (noOfCases < 1 || noOfCases > 100) {
				System.out.println("Invalid input");
			} else {
				input = new int[noOfCases];
				int count = 0;
				//System.out.println("Enter " + noOfCases
				//		+ " numbers (>=2 and <=100):");
				while (count < noOfCases) {
					input[count] = in.nextInt();
					count++;
				}
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
	}

	private static void calculate() {

		try {
			result = new String[noOfCases];

			for (int i = 0; i < noOfCases; i++) {
				int noOfMatchSticks = input[i];
				String resultString = "";

				//resultString = calculateMinMax(noOfMatchSticks);

				System.out.println(resultString);
				result[i] = resultString;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}
}