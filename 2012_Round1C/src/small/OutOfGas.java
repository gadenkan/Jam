package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class OutOfGas {
	private static String[] result;
	private static int noOfCases;
	public static void main(String[] args) {

		//findTime(4, 1, 3);
		readInputFile();
		//writeToFile(result);
	}

	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream("B-small-attempt.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			result = new String[noOfCases];
			for (int i = 0; i < noOfCases; i++) {
				strLine = br.readLine();
				String[] temp = strLine.split(" ");
				String resultString = "";
				double distance = Float.parseFloat(temp[0]);
				int lines = Integer.parseInt(temp[1]);
				int noOfAcc  = Integer.parseInt(temp[2]);
				double[] times = new double[lines];
				double[] positions = new double[lines];
				double[] accs = new double[noOfAcc];
				
				for(int j=0;j<lines;j++){
					strLine = br.readLine();
					temp = strLine.split(" ");
					times[j] = Float.parseFloat(temp[0]);
					positions[j] = Float.parseFloat(temp[1]);
				}
				strLine = br.readLine();
				temp = strLine.split(" ");
				for(int j=0;j<noOfAcc;j++){
					accs[j] = Float.parseFloat(temp[j]);
					double totalTime=0;
					double currentSpeed=0;
					double speed=0;
					double checkPointDistance = 0;
					
					for(int k=0;k<lines;k++){
						
						
						checkPointDistance = positions[k] - checkPointDistance;
						double checkPointTime = times[k] - totalTime;
						if(checkPointDistance > distance){
							checkPointDistance = distance;
							//checkPointTime = newTime();
						}
						if(checkPointDistance==0){
							continue;
						}
						double timeToReachCheckPoint = 0;
						
						timeToReachCheckPoint = findTime(currentSpeed,(double)(0.5 *accs[j]),-checkPointDistance);
						 
						
						if(timeToReachCheckPoint < checkPointTime){
							totalTime = totalTime + checkPointTime;
						}else{
							totalTime = totalTime + timeToReachCheckPoint;
						}
						speed = currentSpeed + accs[j] * timeToReachCheckPoint;
						currentSpeed = speed;
						System.out.println(totalTime+ ". speed: "+speed);
					}
					System.out.println();
					resultString = resultString+"\n"+totalTime;
				}
				
				System.out.println("Case #" + (i + 1) + ":" + resultString);
				result[i] = "Case #" + (i + 1) + ":" + resultString;
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static double findTime(double currentSpeed, double f,
			double checkPointDistance) {
		double a = f;
		double b = currentSpeed;
		double c = checkPointDistance;
		double time1 =0;
		double time2 =0;
		double temp;
		
		double b24ac = (b*b) - (4*a*c);
		if(b24ac<0){
			return -10000;
		}else{
			temp = (double) Math.sqrt(b24ac);
			time1 = (-b + temp)/ (2*a);
			time2 = (-b - temp)/ (2*a);
		}
		
		System.out.println("time1: "+time1+". time2: "+time2);
		if(time1 < 0){
			return time2;
		}else if (time2 < 0) {
			return time1;
		}else{
			return Math.min(time1, time2);
		}
	}

	public static void writeToFile(String args[]) {
		try {
			FileWriter fstream = new FileWriter("B-small-attempt.out");
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
