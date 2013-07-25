package watershed;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Watershed {
	
	private static int noOfMaps;
	
	public static void main(String[] args) throws IOException{

		readInputFile();
		

	}

	private static void readInputFile() {

		try{
			// Open the file that is the first command line parameter
			FileInputStream fstream = new FileInputStream("B-small-practice.in");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			noOfMaps = Integer.parseInt(br.readLine());
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				// Print the content on the console
				System.out.println (strLine);
			}
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
