package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HallOfMirrors {

	private static int noOfCases;
	private static String[] result;
	private static String inputFile = "D-small-pra.in";
	private static String outputFile = "D-small-attempt0.out";
	
	public static void main(String[] args) {


		readInputFile();

		//writeToFile(result);
	}

	public static void writeToFile(String args[]) {
		try {
			FileWriter fstream = new FileWriter(outputFile);
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
			FileInputStream fstream = new FileInputStream(inputFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];
			
			for(int i=0;i<noOfCases;i++){
				strLine = br.readLine();
				String[] temp = strLine.split(" ");
				int rows = Integer.parseInt(temp[0]);
				int columns = Integer.parseInt(temp[1]);
				int dValue = Integer.parseInt(temp[2]);
				int xOfX=0;
				int yOfX=0;
				String[][] grid = new String[rows][columns];
				for(int j=0;j<rows;j++){
					strLine = br.readLine();
					for(int k=0;k<columns;k++){
						grid[j][k] = String.valueOf(strLine.charAt(k));
						if(grid[j][k].equalsIgnoreCase("X")){
							xOfX = k;
							yOfX = j;
						}
					}
				}
				
				// Display the input grid
				for(int j=0;j<rows;j++){
					for(int k=0;k<columns;k++){
						System.out.print(" "+grid[j][k]); 
					}
					System.out.println();
				}
				System.out.println();
				// End of display
				
				int totalSum = getNoOfReflections(grid, dValue, xOfX, yOfX);
				System.out.println("Case #" + (i + 1) + ": " + totalSum);
				result[i] = "Case #" + (i + 1) + ": " + totalSum;
			}
			

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static int getNoOfReflections(String[][] grid, int dValue, int xOfX, int yOfX) {
		
		return 0;
	}

}
