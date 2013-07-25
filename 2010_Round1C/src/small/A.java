package small;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class A implements Runnable {


	BufferedReader in;
	BufferedWriter out;
	static String inputFile = "A-small-practice.in"; // attempt0
	static String outputFile = "A-small-practice.out";


	public static void main(String[] args) {
		new Thread( new A()).start();
	}

	public String readLine() throws Exception {

		return in.readLine();

	}

	public void run() {
		try {
			in = new BufferedReader( new FileReader( inputFile ));
			out = new BufferedWriter( new FileWriter( outputFile ));

			solve();
			out.flush();
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}

	private void solve() throws Exception {

		int noOfCases = Integer.parseInt(readLine());

		for(int i=0;i<noOfCases;i++){
			
			int noOfWires = Integer.parseInt(readLine());
			
			//float[] slope = new float[noOfWires];
			int x[]  = new int[noOfWires];
			int y[] = new int[noOfWires];
			
			
			int result=0;
			
			for(int j=0;j<noOfWires;j++){
				
				String wireString = readLine();
				
				String[] s = wireString.split(" ");
				
				x[j] = Integer.parseInt(s[0]);
				y[j] = Integer.parseInt(s[1]);
				
				
				//slope[j] = y[j]/x[j];
				
			}
			
			for(int j=0;j<noOfWires;j++){
				
				for(int k=0;k<noOfWires;k++){
					
					if(x[j]<x[k] && y[j]>y[k]){
						System.out.println(x[j] +" "+x[k]+" "+ y[j]+" "+y[k]);
						result++;
					}
				}
				
			}
			
			System.out.println("Case #"+(i+1)+": "+result);
			out.write("Case #"+(i+1)+": "+result + "\n");
			
		}
	}
}
