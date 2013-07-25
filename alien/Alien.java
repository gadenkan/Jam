package alien;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Alien {
	static List<Integer> charCount = new ArrayList<Integer>();
	static List<String> knownWords = new ArrayList<String>();
	static List<String> unknownWords = new ArrayList<String>();

	public  static void main(String[] args) {



		readInputFile();

		System.out.println(charCount);
		System.out.println(knownWords);
		System.out.println(unknownWords);

		for(int i=0;i<unknownWords.size();i++){
			int caseCount = 0;
			List<String> currentWordList = new ArrayList<String>();
			// Get the List of words,say "currentWordList", from the combination of tokens from unknownWords.get(i)
			//System.out.println(unknownWords.get(i));
			currentWordList = getCurrentWordList(unknownWords.get(i));



			for(int j=0;j<knownWords.size();j++){
				for(int k=0;k<currentWordList.size();k++){
					//use "currentWordList" to compare with knownWords.get(j)
					if(knownWords.get(j).equalsIgnoreCase(currentWordList.get(k))){
						caseCount++;
					}
				}

			}

			int temp = i+1;			
			System.out.println("Case #"+temp+": "+caseCount);

		}

	}

	private static List<String> getCurrentWordList(String unknownToken) {

		List<String> currentWordList = new ArrayList<String>();

		System.out.println("In getCurrentWordList");
		// GETTING TOKEN LIST
		int bracketOpen = 0;

		List<Object> listOfTokens = new ArrayList<Object>();
		List<String> currentTokenList = new ArrayList<String>();
		List<String> innerList = new ArrayList<String>();
		String temp = "";
		for(int i=0;i<unknownToken.length();i++){


			if(unknownToken.charAt(i) == '(' ){
				bracketOpen = 1;

				innerList = new ArrayList<String>();
				currentTokenList = new ArrayList<String>();
				if(temp != ""){
					currentTokenList.add(temp);
					listOfTokens.add(currentTokenList);
					temp = "";
				}
			}
			else if(unknownToken.charAt(i) == ')'){

				bracketOpen = 0;
				listOfTokens.add(innerList);

			}
			else{
				if(bracketOpen == 0){
					temp = temp+unknownToken.charAt(i);
				}
				if(bracketOpen == 1){
					innerList.add(unknownToken.substring(i, i+1));

				}
			}



		}
		if(temp!=""){
			currentTokenList = new ArrayList<String>();
			currentTokenList.add(temp);
			listOfTokens.add(currentTokenList);
			temp="";
		}

		// END-- GETTING TOKEN LIST

		currentWordList = makeWords(listOfTokens);

		return currentWordList;
	}



	private static List<String> makeWords(List<Object> listOfTokens) {


		List<String> listOfWords = new ArrayList<String>();

		
		return listOfWords;
	}

	private static void readInputFile() {

		String[] strArray = new String[3];

		try{
			// Open the file that is the first command line parameter
			FileInputStream fstream = new FileInputStream("A-small-practice.in");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			//Read File Line By Line
			strLine = br.readLine();
			if(strLine != null)   {
				// Print the content on the console
				strArray = strLine.split(" ");
				charCount.add(Integer.parseInt(strArray[0]));
				charCount.add(Integer.parseInt(strArray[1]));
				charCount.add(Integer.parseInt(strArray[2]));
				//System.out.println(charCount);	
			}
			//Close the input stream

			for(int i = 0; i<charCount.get(1);i++){

				strLine = br.readLine();
				knownWords.add(strLine);
			}

			for(int i = 0; i<charCount.get(2);i++){				
				strLine = br.readLine();
				unknownWords.add(strLine);
			}

			in.close();

		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
