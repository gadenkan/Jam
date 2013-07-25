package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class A {
	private static String[] result;
	private static int noOfCases;
	public static void main(String[] args) {

		readInputFile();
		result = new String[noOfCases];
		writeToFile(result);
	}
	
	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream("B-large.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void writeToFile(String args[]) {
		try {
			FileWriter fstream = new FileWriter("B-large.out");
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
