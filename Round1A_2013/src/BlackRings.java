import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BlackRings {

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
				BigDecimal r = new BigDecimal(temp[0]);
				BigDecimal t = new BigDecimal(temp[1]);
				BigDecimal used = new BigDecimal("0");
				BigDecimal temp1 = new BigDecimal("-3");
				double x = (double) 22 / 7;
				BigDecimal pi = new BigDecimal(String.valueOf(x));
				long count = 0;
				while (used.compareTo(t) == -1) {
					temp1 = temp1.add(new BigDecimal("4"));
					used = used.add(pi.multiply((r
							.multiply(new BigDecimal("2"))).add(temp1)));
					count++;
				}

				System.out.println("Case #" + (i + 1) + ":" + count);
				result[i] = "Case #" + (i + 1) + ":" + count;
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
