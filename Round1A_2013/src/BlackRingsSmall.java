import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BlackRingsSmall {

	private static String[] result;
	private static int noOfCases;

	public static void main(String[] args) {

		readInputFile();
		writeToFile(result);
	}

	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream("A-small-attempt2.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];

			for (int i = 0; i < noOfCases; i++) {
				strLine = br.readLine();
				String[] temp = strLine.split(" ");
				long r = Long.parseLong(temp[0]);
				long t = Long.parseLong(temp[1]);
				long used = 0;
				long temp1 = -3;
				long count = 0;
				while (used<t) {
					temp1 = temp1+4;
					used = used+((2*r)+temp1);
					count++;
				}
				if(used>t){
					count--;
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
