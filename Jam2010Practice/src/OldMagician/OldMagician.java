package OldMagician;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sun.xml.internal.stream.writers.WriterUtility;

public class OldMagician {

	private static int noOfCases;
	private static String[] cases;
	private static String[] result;
	public static void main(String[] args) throws IOException{

		readInputFile();

		for(int i=0;i<noOfCases;i++){

			String result2;
			String[] a = cases[i].split(" ");
			int b = Integer.parseInt(a[1]);

			if(b%2 == 0)
				result2 = "WHITE";

			else
				result2 = "BLACK";

			System.out.println(" Case #"+(i+1)+": "+result2);
			result[i] = "Case #"+(i+1)+": "+result2;
		}
		
		writeToFile(result);

	}

	private static void readInputFile() {

		try{
			// Open the file that is the first command line parameter
			FileInputStream fstream = new FileInputStream("A-small-practice1.in");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			noOfCases = Integer.parseInt(br.readLine());
			System.out.println(noOfCases);
			cases = new String[noOfCases];
			result = new String[noOfCases];
			//Read File Line By Line
			int i=0;
			while ((strLine = br.readLine()) != null)   {
				// Print the content on the console
				System.out.println (strLine);
				cases[i++] = strLine;
			}
			
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}


	public static void writeToFile(String args[])
	{
		try{
			// Create file 
			FileWriter fstream = new FileWriter("A-small-practiced.out");
			BufferedWriter out = new BufferedWriter(fstream);
			for(int i=0;i<args.length;i++){
				out.write(args[i]);
				out.newLine();
			}
			//Close the output stream
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}


}
