package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FallingDiamonds {

	private static String[] result;
	private static int noOfCases;

	public static void main(String[] args) {

		readInputFile();
		writeToFile(result);
	}

	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream("A-small-attempt.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];

			for (int i = 0; i < noOfCases; i++) {
				strLine = br.readLine();
				String[] temp = strLine.split(" ");
				int noOfDiamonds = Integer.parseInt(temp[0]);
				int x = Integer.parseInt(temp[1]);
				int y = Integer.parseInt(temp[2]);

				int matrixSize = (((int) Math.sqrt(2*noOfDiamonds))*2)-1;
				System.out.println(matrixSize);
				/*for (int m = 0; m < noOfDiamonds; m++) {
					
					for (int j = 0; j < matrixSize; j++) {

						for (int k = 0; k < matrixSize; k++) {

						}

					}
				}*/
				String resultString = "";

				System.out.println("Case #" + (i + 1) + ":" + resultString);
				result[i] = "Case #" + (i + 1) + ":" + resultString;
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void writeToFile(String args[]) {
		try {
			FileWriter fstream = new FileWriter("A-small-attempt.out");
			BufferedWriter out = new BufferedWriter(fstream);
			for (int i = 0; i < args.length; i++) {
				out.write(args[i]);
				if (i != args.length - 1)
					out.newLine();
			}
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
