import java.math.BigInteger;
import java.util.Scanner;

public class SimpleArithematic {

	private static String[] result;
	private static int noOfCases;
	private static String[] input;

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
				input = new String[noOfCases];
				int count = 0;
				// System.out.println("Enter " + noOfCases
				// + " numbers (>=2 and <=100):");
				while (count < noOfCases) {
					input[count] = in.next();
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
				String str = input[i];
				System.out.println(str);
				String resultString = "";
				if ((str.split("\\+")).length > 1) {
					add(str);
				} else if ((str.split("\\-")).length > 1)
					subtract(str);
				else
					multiply(str);

				System.out.println(resultString);
				result[i] = resultString;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// System.err.println("Error: " + e.getMessage());
		}
	}

	private static void multiply(String str) {
		// TODO Auto-generated method stub

	}

	private static void subtract(String str) {
		// TODO Auto-generated method stub

	}

	private static void add(String str) {

		try {
			String temp[] = str.split("\\+");
			int[] lengths = new int[4];
			BigInteger b1 = new BigInteger(temp[0]);
			BigInteger b2 = new BigInteger(temp[1]);
			temp[1] = "+" + temp[1];
			lengths[0] = temp[0].length();
			lengths[1] = temp[1].length();

			BigInteger sum = b1.add(b2);
			lengths[3] = b2.toString().length();
			
			int length = 0;

			length = Math.max(lengths[0], lengths[1]);
			length = Math.max(length, lengths[2]);
			lengths[2] = length;
			for (int j = 0; j < 4; j++) {
				int offset = length - lengths[j];
				//System.out.println(lengths[j]);
				for (int i = 0; i < length; i++) {

					if (i < offset) {
						System.out.print(" ");
					} else {
						if (j == 0 || j == 1)
							System.out.print(temp[j].charAt(i-offset));
						else if (j == 2)
							System.out.print("-");
						else {
							System.out.print(sum.toString().charAt(i-offset));
						}
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
