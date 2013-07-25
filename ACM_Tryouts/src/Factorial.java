import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
	private static int[] result;
	private static int noOfCases;
	private static int[] input;

	public static void main(String[] args) {

		readStdInput();
		calculate();
		// System.out.println(noOfMod(125, 5));
		//System.out.println(updateNonZeroUnit(3, 1000000000));
	}

	private static void calculate() {
		try {
			result = new int[noOfCases];

			for (int i = 0; i < noOfCases; i++) {
				int resultInt = 0;
				int current = input[i];

				resultInt = calculateNoOfZeros(current);
				//calculateNoOfZeros2(current);
				System.out.println(resultInt);
				result[i] = resultInt;
			}

		} catch (Exception e) {
			//e.printStackTrace();
			// System.err.println("Error: " + e.getMessage());
		}

	}

	private static int calculateNoOfZeros(int current) {

		int nonZeroUnitsNo = 1;
		int noOfZeros = 0;
		int temp = 1;
		for (int i = 1; i <= current; i++) {
			// temp = temp*i;
			//System.out.println("nonZeroUnitsNo "+nonZeroUnitsNo);
			if (i % 5 == 0) {
				//if (i % 10 == 0) {
					//noOfZeros++;
				//} else {
					int noOfMod5 = noOfMod(i, 5);
					int noOfMod2 = noOfMod(nonZeroUnitsNo, 2);
					//System.out.println("noOfMod5 "+noOfMod(i, 5));
					//System.out.println("noOfMod2 "+noOfMod(nonZeroUnitsNo, 2));
					//System.out.println("Math.min(noOfMod5, noOfMod2) "+Math.min(noOfMod5, noOfMod2) );
					noOfZeros = noOfZeros + Math.min(noOfMod5, noOfMod2);
				//}
			}
			nonZeroUnitsNo = updateNonZeroUnit(nonZeroUnitsNo, i);
			//System.out.println("nonZeroUnitsNo "+nonZeroUnitsNo);
			//System.out.println("current: "+i+". noOfZeros "+noOfZeros);
			//System.out.println();
		}
		
		return noOfZeros;
	}

	private static int updateNonZeroUnit(int nonZeroUnitsNo, int current) {

		//System.out.println("nonZeroUnitsNo * current = "+nonZeroUnitsNo * current);

		int tempCurrent = current;

		while (tempCurrent % 10 == 0)
			tempCurrent = tempCurrent / 10;
		
		tempCurrent = tempCurrent % 10000000;
		int temp = nonZeroUnitsNo * tempCurrent;
		
		while (temp % 10 == 0)
			temp = temp / 10;

		return temp % 10000000;
	}

	private static int noOfMod(int current, int modNo) {
		int x = 0;
		int temp = current;
		while (temp % modNo == 0) {
			x++;
			temp = temp / modNo;
		}
		return x;
	}

	private static void calculateNoOfZeros2(int current) {
		int temp = 1;
		int noOfZeros = 0;
		int firstNonZeroNo = 0;
		BigInteger b1 = new BigInteger(String.valueOf(current));
		BigInteger b2 = new BigInteger("1");
		for (int i = 1; i <= current; i++) {
			//System.out.println("temp: " + b2 + ". i:" + i + ". final: "
					//+ b2.multiply(new BigInteger(String.valueOf(i))));
			temp = temp * i;
			b2 = b2.multiply(new BigInteger(String.valueOf(i)));
			System.out.println(temp);
			if (current % 5 == 0) {
				if (current % 10 == 0) {
					noOfZeros++;
				} else {

				}
			}
		}
		//System.out.println(temp);
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
}
