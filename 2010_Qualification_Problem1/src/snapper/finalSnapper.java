package snapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class finalSnapper {

	private static int noOfCases;
	private static int[] noOfSnappers;
	private static int[] noOfClicks;
	private static String[] result;

	public static void main(String[] args) {
		readInputFile();

		result = new String[noOfCases];
		for(int i=0;i<noOfCases;i++){

			int x = noOfClicks[i];
			String s= Integer.toBinaryString(x);
			System.out.println(s +"  s"+noOfSnappers[i]+"  c"+noOfClicks[i]);
			int snappers = noOfSnappers[i];

			if(s.length() < snappers){
				result[i] = "Case #"+(i+1)+": OFF";
				System.out.println("Case #"+(i+1)+": OFF");
			}else{
				int y = s.length() - snappers;
				boolean flag = true;
				for(;y<s.length();y++){
					if(s.charAt(y)!= '1'){
						flag = false;
						break;
					}
				}				
				
				//char c = s.charAt(s.length() - (snappers+1));
				if(flag){
					result[i] = "Case #"+(i+1)+": ON";
					System.out.println("Case #"+(i+1)+": ON");
				}else{
					result[i] = "Case #"+(i+1)+": OFF";
					System.out.println("Case #"+(i+1)+": OFF");
				}
			}			
		}

		writeToFile(result);

	}

	private static void readInputFile() {

		try{
			FileInputStream fstream = new FileInputStream("A-small-practice.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			noOfCases = Integer.parseInt(br.readLine());
			noOfSnappers = new int[noOfCases];
			noOfClicks = new int[noOfCases];
			int i=0;
			while ((strLine = br.readLine()) != null)   {
				System.out.println (strLine);
				String temp[] = strLine.split(" ");
				noOfSnappers[i]= Integer.parseInt(temp[0]);
				noOfClicks[i] = Integer.parseInt(temp[1]);
				i++;
			}

			in.close();
		}catch (Exception e){
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}


	public static void writeToFile(String args[])
	{
		try{
			FileWriter fstream = new FileWriter("A-small-practice.out");
			BufferedWriter out = new BufferedWriter(fstream);
			for(int i=0;i<args.length;i++){
				out.write(args[i]);
				if(i!= args.length-1)
					out.newLine();
			}
			out.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}

}
