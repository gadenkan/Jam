package themepark;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ThemePark {
	private static int noOfCases;

	private static String[] result;
	private static int[] noOfRuns;
	private static int[] costerCapacity;
	private static int[] noOfGroups;
	private static int[][] groups;
	private static int index;
	public static void main(String[] args) {

		readInputFile();

		result = new String[noOfCases];
		for(int i=0;i<noOfCases;i++){
			index =0 ;
			int totalSum =0 ;

			int runs = noOfRuns[i];
			int capacityLimit = costerCapacity[i];
			int groupNumber = noOfGroups[i];
			int[] group = new int[groupNumber];
			group = groups[i];

			for(int j=0; j<runs;j++){
				int presentCapacity = 0;
				int groupNoTemp =1;
				while(presentCapacity <= capacityLimit && groupNumber >= groupNoTemp){
					//System.out.println(groups[i][j]);
					System.out.println(presentCapacity +" "+ capacityLimit+"  "+group[index]+"  "+index);
					presentCapacity  = presentCapacity + group[index];
					if(presentCapacity <= capacityLimit){
						totalSum = totalSum + group[index];
						index++;
						groupNoTemp++;
						index = index%noOfGroups[i];
					}
				}
				System.out.println("presernt sum: "+totalSum);

			}

			System.out.println("Case #"+(i+1)+": "+totalSum);
			result[i] = "Case #"+(i+1)+": "+totalSum;

		}
		
		writeToFile(result);
	}

	private static void readInputFile() {

		try{
			FileInputStream fstream = new FileInputStream("C-small-practice.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			noOfCases = Integer.parseInt(br.readLine());
			noOfRuns = new int[noOfCases];
			costerCapacity = new int[noOfCases];
			noOfGroups = new int[noOfCases];
			groups = new int[noOfCases][];		
			for(int i=0;i<noOfCases;i++){
				strLine = br.readLine();
				String temp[] = strLine.split(" ");
				noOfRuns[i] = Integer.parseInt(temp[0]);
				costerCapacity[i] = Integer.parseInt(temp[1]);
				noOfGroups[i] = Integer.parseInt(temp[2]);
				groups[i] = new int[noOfGroups[i]];
				strLine = br.readLine();
				temp = strLine.split(" ");
				for(int j=0;j<temp.length;j++){
					groups[i][j] = Integer.parseInt(temp[j]);
				}

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
			FileWriter fstream = new FileWriter("C-small-practice.out");
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
