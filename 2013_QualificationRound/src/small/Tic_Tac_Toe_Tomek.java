package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Tic_Tac_Toe_Tomek {

	private static String[] result;
	private static int noOfCases;
	static int dotCount;
	public static void main(String[] args) {

		readInputFile();
		writeToFile(result);
	}

	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream("A-large.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];
			
			for (int i = 0; i < noOfCases; i++) {
				
				String resultString = "";
				char[][] matrix=new char[4][4];
				dotCount=0;
				for(int j=0;j<4;j++){
					strLine = br.readLine();
					for(int n=0;n<4;n++){
						matrix[j][n] = strLine.charAt(n);
						if(matrix[j][n]=='.'){
							dotCount++;
						}
					}
				}
				strLine = br.readLine();
				resultString = solve(matrix);
				if(resultString==null){
					if(dotCount>0){
						resultString="Game has not completed";
					}else{
						resultString = "Draw";
					}
				}
				
				System.out.println("Case #" + (i + 1) + ": " + resultString);
				result[i] = "Case #" + (i + 1) + ": " + resultString;
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static String solve(char[][] matrix) {

		if((matrix[0][0]=='T' ||matrix[0][0]=='X') && 
				(matrix[0][1]=='T' ||matrix[0][1]=='X') && 
				(matrix[0][2]=='T' ||matrix[0][2]=='X') && 
				(matrix[0][3]=='T' ||matrix[0][3]=='X')){
			return "X won";
		}else if((matrix[1][0]=='T' ||matrix[1][0]=='X') && 
				(matrix[1][1]=='T' ||matrix[1][1]=='X') && 
				(matrix[1][2]=='T' ||matrix[1][2]=='X') && 
				(matrix[1][3]=='T' ||matrix[1][3]=='X')){
			return "X won";
		}else if((matrix[2][0]=='T' ||matrix[2][0]=='X') && 
				(matrix[2][1]=='T' ||matrix[2][1]=='X') && 
				(matrix[2][2]=='T' ||matrix[2][2]=='X') && 
				(matrix[2][3]=='T' ||matrix[2][3]=='X')){
			return "X won";
		}else if((matrix[3][0]=='T' ||matrix[3][0]=='X') && 
				(matrix[3][1]=='T' ||matrix[3][1]=='X') && 
				(matrix[3][2]=='T' ||matrix[3][2]=='X') && 
				(matrix[3][3]=='T' ||matrix[3][3]=='X')){
			return "X won";
		}else if((matrix[0][0]=='T' ||matrix[0][0]=='X') && 
				(matrix[1][0]=='T' ||matrix[1][0]=='X') && 
				(matrix[2][0]=='T' ||matrix[2][0]=='X') && 
				(matrix[3][0]=='T' ||matrix[3][0]=='X')){
			return "X won";
		}else if((matrix[0][1]=='T' ||matrix[0][1]=='X') && 
				(matrix[1][1]=='T' ||matrix[1][1]=='X') && 
				(matrix[2][1]=='T' ||matrix[2][1]=='X') && 
				(matrix[3][1]=='T' ||matrix[3][1]=='X')){
			return "X won";
		}else if((matrix[0][2]=='T' ||matrix[0][2]=='X') && 
				(matrix[1][2]=='T' ||matrix[1][2]=='X') && 
				(matrix[2][2]=='T' ||matrix[2][2]=='X') && 
				(matrix[3][2]=='T' ||matrix[3][2]=='X')){
			return "X won";
		}else if((matrix[0][3]=='T' ||matrix[0][3]=='X') && 
				(matrix[1][3]=='T' ||matrix[1][3]=='X') && 
				(matrix[2][3]=='T' ||matrix[2][3]=='X') && 
				(matrix[3][3]=='T' ||matrix[3][3]=='X')){
			return "X won";
		}else if((matrix[0][0]=='T' ||matrix[0][0]=='X') && 
				(matrix[1][1]=='T' ||matrix[1][1]=='X') && 
				(matrix[2][2]=='T' ||matrix[2][2]=='X') && 
				(matrix[3][3]=='T' ||matrix[3][3]=='X')){
			return "X won";
		}else if((matrix[0][3]=='T' ||matrix[0][3]=='X') && 
				(matrix[1][2]=='T' ||matrix[1][2]=='X') && 
				(matrix[2][1]=='T' ||matrix[2][1]=='X') && 
				(matrix[3][0]=='T' ||matrix[3][0]=='X')){
			return "X won";
		}
		
		
		
		
		
		if((matrix[0][0]=='T' ||matrix[0][0]=='O') && 
				(matrix[0][1]=='T' ||matrix[0][1]=='O') && 
				(matrix[0][2]=='T' ||matrix[0][2]=='O') && 
				(matrix[0][3]=='T' ||matrix[0][3]=='O')){
			return "O won";
		}else if((matrix[1][0]=='T' ||matrix[1][0]=='O') && 
				(matrix[1][1]=='T' ||matrix[1][1]=='O') && 
				(matrix[1][2]=='T' ||matrix[1][2]=='O') && 
				(matrix[1][3]=='T' ||matrix[1][3]=='O')){
			return "O won";
		}else if((matrix[2][0]=='T' ||matrix[2][0]=='O') && 
				(matrix[2][1]=='T' ||matrix[2][1]=='O') && 
				(matrix[2][2]=='T' ||matrix[2][2]=='O') && 
				(matrix[2][3]=='T' ||matrix[2][3]=='O')){
			return "O won";
		}else if((matrix[3][0]=='T' ||matrix[3][0]=='O') && 
				(matrix[3][1]=='T' ||matrix[3][1]=='O') && 
				(matrix[3][2]=='T' ||matrix[3][2]=='O') && 
				(matrix[3][3]=='T' ||matrix[3][3]=='O')){
			return "O won";
		}else if((matrix[0][0]=='T' ||matrix[0][0]=='O') && 
				(matrix[1][0]=='T' ||matrix[1][0]=='O') && 
				(matrix[2][0]=='T' ||matrix[2][0]=='O') && 
				(matrix[3][0]=='T' ||matrix[3][0]=='O')){
			return "O won";
		}else if((matrix[0][1]=='T' ||matrix[0][1]=='O') && 
				(matrix[1][1]=='T' ||matrix[1][1]=='O') && 
				(matrix[2][1]=='T' ||matrix[2][1]=='O') && 
				(matrix[3][1]=='T' ||matrix[3][1]=='O')){
			return "O won";
		}else if((matrix[0][2]=='T' ||matrix[0][2]=='O') && 
				(matrix[1][2]=='T' ||matrix[1][2]=='O') && 
				(matrix[2][2]=='T' ||matrix[2][2]=='O') && 
				(matrix[3][2]=='T' ||matrix[3][2]=='O')){
			return "O won";
		}else if((matrix[0][3]=='T' ||matrix[0][3]=='O') && 
				(matrix[1][3]=='T' ||matrix[1][3]=='O') && 
				(matrix[2][3]=='T' ||matrix[2][3]=='O') && 
				(matrix[3][3]=='T' ||matrix[3][3]=='O')){
			return "O won";
		}else if((matrix[0][0]=='T' ||matrix[0][0]=='O') && 
				(matrix[1][1]=='T' ||matrix[1][1]=='O') && 
				(matrix[2][2]=='T' ||matrix[2][2]=='O') && 
				(matrix[3][3]=='T' ||matrix[3][3]=='O')){
			return "O won";
		}else if((matrix[0][3]=='T' ||matrix[0][3]=='O') && 
				(matrix[1][2]=='T' ||matrix[1][2]=='O') && 
				(matrix[2][1]=='T' ||matrix[2][1]=='O') && 
				(matrix[3][0]=='T' ||matrix[3][0]=='O')){
			return "O won";
		}
		
		
		return null;
	}
	
	public static void writeToFile(String args[]) {
		try {
			FileWriter fstream = new FileWriter("A-large.out");
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
