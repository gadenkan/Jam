package small;

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
			FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];

			for (int i = 0; i < noOfCases; i++) {
				strLine = br.readLine();
				String[] temp = strLine.split(" ");
				int low = Integer.parseInt(temp[0]);
				int high = Integer.parseInt(temp[1]);
				String resultString = "";
				int count=0;
				for(int j=low;j<=high;j++){
					
					if(isPalindrome(j)){
						int x = (int) Math.sqrt(j);
						double y = Math.sqrt(j);
						if(x==y && isPalindrome(x)){
							count++;
						}
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

	public static boolean isPalindrome(int x) {

		
		StringBuilder numberString = new StringBuilder(String.valueOf(x));
		int r = Integer.parseInt(numberString.reverse().toString());
		
		if (x==r){
			return true;
		}
		else {
			return false;
		}

	}

	public static void writeToFile(String args[]) {
		try {
			FileWriter fstream = new FileWriter("C-small-attempt0.out");
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
