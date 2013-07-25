package large;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Fair_and_Square {

	private static String[] result;
	private static int noOfCases;

	public static void main(String[] args) {

		readInputFile();
		writeToFile(result);
	}

	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream("C-large-1.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];

			for (int i = 0; i < noOfCases; i++) {
				strLine = br.readLine();
				String[] temp = strLine.split(" ");
				long low = (long) Math.sqrt(Long.parseLong(temp[0]));
				long high = (long) Math.sqrt(Long.parseLong(temp[1]));
				long count=0l;
				for(long j=low;j<=high;j++){
					if(isPalindrome(j)){
							count++;
					}
				}

				System.out.println("Case #" + (i + 1) + ": " + count);
				result[i] = "Case #" + (i + 1) + ": " + count;
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static boolean isPalindrome(long x) {

		
		StringBuilder numberString = new StringBuilder(String.valueOf(x));
		long r = Long.parseLong(numberString.reverse().toString());
		
		if (x==r){
			return true;
		}
		else {
			return false;
		}

	}

	public static void writeToFile(String args[]) {
		try {
			FileWriter fstream = new FileWriter("C-large.out");
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
