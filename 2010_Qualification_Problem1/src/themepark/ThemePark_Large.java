package themepark;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThemePark_Large {

	private static int noOfCases;

	private static String[] result;
	private static int[] noOfRuns;
	private static int[] costerCapacity;
	private static int[] noOfGroups;
	private static int[][] groups;
	private static int index;
	private static long totalSumOfTheCase;
	private static int noOfRunsOfTheCase;
	private static int[] groupOfTheCase;
	private static long capacityLimitOfTheCase;
	private static List<Long> presentSumOfTheCase;
	public static void main(String[] args) {

		readInputFile();

		result = new String[noOfCases];
		for(int i=0;i<noOfCases;i++){
			index =0 ;
			totalSumOfTheCase =0 ;

			noOfRunsOfTheCase = noOfRuns[i];
			capacityLimitOfTheCase = costerCapacity[i];
			int groupNumber = noOfGroups[i];
			 groupOfTheCase = new int[groupNumber];
			groupOfTheCase = groups[i];
			Set<Integer> loopSet = new HashSet<Integer>();
			int loopRuns;
			boolean calcDone = false;
			Map<Integer,Integer> mapRunsBeforeLoopingBeings = new HashMap<Integer, Integer>();
			presentSumOfTheCase = new ArrayList<Long>();
			for(int j=1; j<=noOfRunsOfTheCase;j++){
				int presentCapacity = 0;
				int groupNoTemp =1;
				
				if(!mapRunsBeforeLoopingBeings.containsKey(index)){
					mapRunsBeforeLoopingBeings.put(index, j-1);
				}
				if(!loopSet.add(index) && !calcDone){
					loopRuns = j-1;
					
					j = calculateLoops(loopRuns,mapRunsBeforeLoopingBeings.get(index));
					calcDone = true;
					continue;
				}
				
				while(presentCapacity <= capacityLimitOfTheCase && groupNumber >= groupNoTemp){
					//System.out.println(groups[i][j]);
					//System.out.println(presentCapacity +" "+ capacityLimit+"  "+groupOfTheCase[index]+"  "+index);
					presentCapacity  = presentCapacity + groupOfTheCase[index];
					if(presentCapacity <= capacityLimitOfTheCase){
						totalSumOfTheCase = totalSumOfTheCase + groupOfTheCase[index];
						index++;
						groupNoTemp++;
						index = index%noOfGroups[i];
					}
				}
				presentSumOfTheCase.add(totalSumOfTheCase);
				System.out.println("presernt sum: "+totalSumOfTheCase);

			}

			System.out.println("Case #"+(i+1)+": "+totalSumOfTheCase);
			result[i] = "Case #"+(i+1)+": "+totalSumOfTheCase;

		}
		
		writeToFile(result);
	}
	
	private static int calculateLoops(int loopRuns, int runsBeforeTheIndex) {

		int j;
		long groupSum=0;
		int noOfLoops;
		if(index != 0){
			
			System.out.println("Runs Before the Looping Begins: "+runsBeforeTheIndex);
			loopRuns = loopRuns - runsBeforeTheIndex;
			j = (loopRuns * ((noOfRunsOfTheCase-runsBeforeTheIndex)/loopRuns))+runsBeforeTheIndex;
			/*for(int i=0;i<groupOfTheCase.length;i++){
				groupSum = groupSum + groupOfTheCase[i];
			}*/
			
			noOfLoops = ((noOfRunsOfTheCase-runsBeforeTheIndex)/loopRuns);
			int size = presentSumOfTheCase.size();
			groupSum = presentSumOfTheCase.get(size-1) - presentSumOfTheCase.get(size-1 - loopRuns);
			System.out.println("Sum of the Loop: "+groupSum);
			totalSumOfTheCase = groupSum + (groupSum * (noOfLoops-1)) + presentSumOfTheCase.get(size-1 - loopRuns);
		}else{
			noOfLoops = (noOfRunsOfTheCase/loopRuns);
			j = loopRuns * (noOfRunsOfTheCase/loopRuns);
			totalSumOfTheCase = totalSumOfTheCase + (totalSumOfTheCase * (noOfLoops-1));
		}
		
		System.out.println("Runs in a loop: "+loopRuns);
		System.out.println("No of Loops: "+noOfLoops);
		
		
		System.out.println("Total Loop Sum So Far: "+totalSumOfTheCase);
		System.out.println("J : "+j);
		
		
		
		return j;
	}

	private static void readInputFile() {

		try{
			FileInputStream fstream = new FileInputStream("C-large-practice.in");
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
			FileWriter fstream = new FileWriter("C-large-practice.out");
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
