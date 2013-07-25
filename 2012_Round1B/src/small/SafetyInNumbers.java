package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class SafetyInNumbers {
	private static String[] result;
	private static int noOfCases;

	public static void main(String[] args) {

		readInputFile();
		// result = new String[noOfCases];
		writeToFile(result);
	}

	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream(
					"A-small-attempt1_1.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];
			for (int i = 0; i < noOfCases; i++) {
				strLine = br.readLine();
				String[] temp = strLine.split(" ");
				int noOfParticipants = Integer.parseInt(temp[0]);
				int[] numbers = new int[noOfParticipants];
				int judgeTotal = 0;
				float value = 0;
				String resultString = "";
				boolean monopoly = false;
				int effectiveNoOfParticipants = noOfParticipants;
				for (int j = 1; j <= noOfParticipants; j++) {
					numbers[j - 1] = Integer.parseInt(temp[j]);
					judgeTotal = judgeTotal + numbers[j - 1];
				}
				System.out.println(judgeTotal);
				for (int j = 0; j < noOfParticipants; j++) {
					if (numbers[j] == judgeTotal) {
						monopoly = true;
						effectiveNoOfParticipants = noOfParticipants - 1;
						break;
					} else {
						if ((float) numbers[j] / judgeTotal > ((float) 1 / noOfParticipants)) {
							effectiveNoOfParticipants = effectiveNoOfParticipants - 1;
						}
					}
				}
				for (int j = 0; j < noOfParticipants; j++) {
					if (numbers[j] == judgeTotal) {
						value = 0;
					} else {
						if (monopoly) {
							value = (float) 100 / (effectiveNoOfParticipants);
						} else {
							value = ((float) 200 / (float) noOfParticipants)
									- (((float) numbers[j] * (float) 100) / (float) judgeTotal);
						}
					}

					// System.out.println(value);
					resultString = resultString + " " + value;
					System.out.println(resultString);
				}
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
			FileWriter fstream = new FileWriter("A-small-attempt1_1.out");
			BufferedWriter out = new BufferedWriter(fstream);
			for (int i = 0; i < args.length; i++) {
				out.write(args[i]);
				if (i != args.length - 1)
					out.newLine();
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}
}
