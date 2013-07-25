package small;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C implements Runnable {


	BufferedReader in;
	BufferedWriter out;
	static String inputFile = "C-small-attempt0.in"; // attempt0
	static String outputFile = "C-small-attempt0.out";


	public static void main(String[] args) {
		new Thread( new C()).start();
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
			String result;
			int noOfBags = Integer.parseInt(readLine());
			String []s = readLine().split(" ");
			int[] bagValues = new int[noOfBags];
			int sum=0;
			for(int j=0;j<noOfBags;j++){
				bagValues[j] = Integer.parseInt(s[j]);
				sum = sum+bagValues[j];
			}
			
		
			if((sum%2)!=0){
				result = "NO";
			}
			else{
				result ="111";
			}
			
			
		
			
			System.out.println("Case #"+(i+1)+": "+result);
			out.write("Case #"+(i+1)+": "+result + "\n");
			
		}
	}
}
