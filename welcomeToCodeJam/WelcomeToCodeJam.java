package welcomeToCodeJam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WelcomeToCodeJam {
	private static String givenString = "welcome to code jam";
	private static int noOfTestCases;
	private static List<String> testCases = new ArrayList<String>();
	

	public static void main(String[] args) throws IOException{

		readInputFile();
		System.out.println(noOfTestCases);
		System.out.println(testCases);
		
		Integer[] testCasesCount = new Integer[noOfTestCases];

		for (int i=0;i<testCases.size();i++){
			String str = testCases.get(i);
			String testString = "";
			int pos = 0;
			for(int j=0;j<givenString.length();j++){
				while(pos < str.length()){
					if(givenString.charAt(j) == str.charAt(pos)){
						testString = testString + str.charAt(pos);
						pos++;
						break;						
					}
					pos++;					
				}

			}
			
			if(testString.equalsIgnoreCase(givenString)){
				if(testCasesCount[i] == null){
					testCasesCount[i] = 1;
				}
				else{
					testCasesCount[i] = testCasesCount[i]+1;
				}
			}
			
			System.out.println("Case #"+(i+1)+": "+testCasesCount[i]);
		}



	}

	private static void readInputFile() {

		try{
			// Open the file that is the first command line parameter
			FileInputStream fstream = new FileInputStream("C-small-practice.in");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			noOfTestCases = Integer.parseInt(strLine = br.readLine());
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				// Print the content on the console
				testCases.add(strLine);
			}
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
