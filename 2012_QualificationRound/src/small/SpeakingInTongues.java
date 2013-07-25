package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class SpeakingInTongues {
	private static int noOfCases;
	private static String[] result;
	
	public static void main(String[] args) {
		
		readInputFile();
		
		
		writeToFile(result);
	}
	
	public static void writeToFile(String args[]) {
		try {
			FileWriter fstream = new FileWriter("A-small-attempt0.out");
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

	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream("A-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];
			for (int i = 0; i < noOfCases; i++) {
				strLine = br.readLine();
				char[] arr = strLine.toCharArray();
				String resultString;
				resultString = translate(arr);
				
				
				System.out.println();
				System.out.println("Case #" + (i + 1) + ": " + resultString);
				result[i] = "Case #" + (i + 1) + ": " + resultString;

			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static String translate(char[] arr) {
		String returnString="";
		for(int i=0;i<arr.length;i++){
			
			switch (arr[i]) {
			case 'a':
				returnString = returnString + "y";
				break;
			case 'b':
				returnString = returnString + "h";
				break;
			case 'c':
				returnString = returnString + "e";
				break;
			case 'd':
				returnString = returnString + "s";
				break;
			case 'e':
				returnString = returnString + "o";
				break;
			case 'f':
				returnString = returnString + "c";
				break;
			case 'g':
				returnString = returnString + "v";
				break;
			case 'h':
				returnString = returnString + "x";
				break;
			case 'i':
				returnString = returnString + "d";
				break;
			case 'j':
				returnString = returnString + "u";
				break;
			case 'k':
				returnString = returnString + "i";
				break;
			case 'l':
				returnString = returnString + "g";
				break;
			case 'm':
				returnString = returnString + "l";
				break;
			case 'n':
				returnString = returnString + "b";
				break;
			case 'o':
				returnString = returnString + "k";
				break;
			case 'p':
				returnString = returnString + "r";
				break;
			
			case 'r':
				returnString = returnString + "t";
				break;
			case 's':
				returnString = returnString + "n";
				break;
			case 't':
				returnString = returnString + "w";
				break;
			case 'u':
				returnString = returnString + "j";
				break;
			case 'v':
				returnString = returnString + "p";
				break;
			case 'w':
				returnString = returnString + "f";
				break;
			case 'x':
				returnString = returnString + "m";
				break;
			case 'y':
				returnString = returnString + "a";
				break;
			case 'z':
				returnString = returnString + "q";
				break;
			case 'q':
				returnString = returnString + "z";
				break;
			case ' ':
				returnString = returnString + " ";
				break;

			default:
				break;
			}
		}
		return returnString;
	}

	
}
