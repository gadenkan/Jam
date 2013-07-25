package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Lawnmower {
	private static String[] result;
	private static int noOfCases;

	public static void main(String[] args) {

		readInputFile();
		writeToFile(result);
	}

	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream("B-large.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];

			for (int i = 0; i < noOfCases; i++) {
				strLine = br.readLine();
				String[] temp = strLine.split(" ");
				//System.out.println(strLine);
				int rows = Integer.parseInt(temp[0]);
				int cols = Integer.parseInt(temp[1]);
				String resultString = "YES";
				int[][] matrix = new int[rows][cols];

				for (int m = 0; m < rows; m++) {
					strLine = br.readLine();
					temp = strLine.split(" ");
					for (int n = 0; n < cols; n++) {
						matrix[m][n] = Integer.parseInt(temp[n]);
					}
				}
				if (rows > 1 && cols > 1)
					resultString = solve(matrix, rows, cols);

				System.out.println("Case #" + (i + 1) + ": " + resultString);
				result[i] = "Case #" + (i + 1) + ": " + resultString;
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static String solve(int[][] matrix, int rows, int cols) {

		int[][] res = new int[rows][cols];
		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < cols; j++) {
				
				boolean mowCol = true;
				boolean mowRow = true;
				
				mowCol = mowCol(matrix, i, j);
				mowRow = mowRow(matrix, i, j);
				
				if(!mowCol && !mowRow){
					return "NO";
				}
				
				if(mowCol){
					for (int m = 0; m < rows; m++) {
						if (matrix[m][j] >= matrix[i][j])
							res[m][j] = matrix[i][j];
					}
				}
				
				if(mowRow){
					for (int m = 0; m < cols; m++) {
						if (matrix[i][m] >= matrix[i][j])
							res[i][m] = matrix[i][j];
					}
				}
			}
		}

//		for (int m = 0; m < rows; m++) {
//			for (int n = 0; n < cols; n++) {
//				System.out.print(res[m][n] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
		boolean match = true;
		for (int m = 0; m < rows; m++) {
			boolean flag = false;
			for (int n = 0; n < cols; n++) {
				//System.out.print(res[m][n] + " ");
				if (res[m][n] != matrix[m][n]) {
					match = false;
					flag = true;
					break;
				}
			}
			//System.out.println();
			if (flag)
				break;
		}
		
		if (match)
			return "YES";
		else
			return "NO";

	}

	private static boolean mowRow(int[][] matrix, int row, int col) {

		int value = matrix[row][col];
		for(int m=0;m<matrix[row].length;m++){
			if(matrix[row][m] > value){
				return false;
			}
		}
		return true;
	}

	private static boolean mowCol(int[][] matrix, int row, int col) {
		int value = matrix[row][col];
		for(int m=0;m<matrix.length;m++){
			if(matrix[m][col] > value){
				return false;
			}
		}
		return true;
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
