import java.util.Scanner;

class Main {
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
			// System.out.print("Enter the number of test cases: ");
			noOfCases = in.nextInt();

			if (noOfCases < 1 || noOfCases > 100) {
				// System.out.println("Invalid input");
			} else {
				input = new int[noOfCases];
				int count = 0;
				// System.out.println("Enter " + noOfCases
				// + " numbers (>=2 and <=100):");
				while (count < noOfCases) {
					input[count] = in.nextInt();
					count++;
				}
			}
			in.close();
		} catch (Exception e) {
			// System.out.println("Invalid Input");
		}
	}

	private static void calculate() {

		try {
			result = new String[noOfCases];

			for (int i = 0; i < noOfCases; i++) {
				int noOfMatchSticks = input[i];
				String resultString = "";

				resultString = calculateMinMax(noOfMatchSticks);

				System.out.println(resultString);
				result[i] = resultString;
			}

		} catch (Exception e) {
			// e.printStackTrace();
			// System.err.println("Error: " + e.getMessage());
		}
	}

	private static String calculateMinMax(int noOfMatchSticks) {
		String min = "", max = "";
		int[] sizes = { 7, 6, 5, 4, 3, 2 };
		int[] minArr = { 8, 6, 2, 4, 7, 1 };
		if (noOfMatchSticks % 2 == 0) {
			int x = noOfMatchSticks / 2;
			for (int i = 0; i < x; i++) {
				max = max + "1";
			}
		} else {
			int x = (noOfMatchSticks - 3) / 2;
			for (int i = 0; i < x; i++) {
				max = max + "1";
			}
			max = "7" + max;
		}

		int temp = 0;

		for (int j = 0; j < sizes.length; j++) {

			temp = noOfMatchSticks / sizes[j];
			if(sizes[j] == 7 && (noOfMatchSticks%7 == 4 || noOfMatchSticks%7 == 3)){
				continue;
			}
			if(sizes[j] == 6 && (noOfMatchSticks%6 == 4)){
				continue;
			}
			//System.out.println("temp(" + sizes[j] + "): " + temp);
			if (temp != 0) {

				if (sizes[j] == 6) {
					int a = 0;
					if(noOfMatchSticks % 6 == 0){
						a = 1;
						min = "6"+min;
					}
					for (; a < temp; a++) {
						min = String.valueOf(minArr[j]) + min;
					}
				} else {
					for (int i = 0; i < temp; i++) {
						min = String.valueOf(minArr[j]) + min;
					}
				}
				noOfMatchSticks = noOfMatchSticks - (temp * sizes[j]);
			}
		}
		if (noOfMatchSticks != 0) {
			min = "10" + min.subSequence(1, min.length());
		}
		String result = min + " " + max;
		return result;
	}

}
