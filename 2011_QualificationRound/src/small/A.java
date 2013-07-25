package small;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A implements Runnable {


	BufferedReader in;
	BufferedWriter out;
	static String inputFile = "A-small-attempt0.in"; // attempt0
	static String outputFile = "A-small-attempt0.out";


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
			
			String []s = readLine().split(" ");
			int noOfButtonPushes = Integer.parseInt(s[0]);
			//System.out.println(noOfButtonPushes);
			List<String> orangeBot = new ArrayList<String>();
			List<String> blueBot = new ArrayList<String>();
			List<String> listButtons = new ArrayList<String>();
			
				
				/*if(s[j].equals("O")){
					orangeButtons.add(Integer.parseInt(s[++j]));
				}else if(s[j].equals("B")){
					blueButtons.add(Integer.parseInt(s[++j]));
				}else{
					System.out.println("MAJOR ERROR****************************************");
				}*/
			
			for(int j=1;j<2*noOfButtonPushes;){
				
				String button = s[j++];
				String number = s[j++];
				//System.out.println("IN If: "+button+number);
				if(button.equals("O")){
					orangeBot.add(button+number);
					listButtons.add(button+number);
				}else if(button.equals("B")){
					blueBot.add(button+number);
					listButtons.add(button+number);
				}else{
					System.out.println("MAJOR ERROR****************************************");
				}
				
			}
			
			String previousBot = String.valueOf(listButtons.get(0).charAt(0));
			int previousButton = Integer.parseInt(String.valueOf(listButtons.get(0).charAt(1)));
			int timeElapsed=0;
			int paralleTimeElapsed=0;
			
			
			int previousBlueButton=1;
			int previousOrangeButton=1;
			
			for(int j=1;j<noOfButtonPushes;j++){
				//System.out.println(listButtons.get(j));
				String currentBot = String.valueOf(listButtons.get(j).charAt(0)); 
				int currentButton = Integer.parseInt(String.valueOf(listButtons.get(j).charAt(1)));
				
				if(currentBot.equals(previousBot)){
					timeElapsed = timeElapsed + Math.abs(currentButton - previousButton)+1;
					paralleTimeElapsed = Math.abs(currentButton - previousButton)+1;
				}else{
					timeElapsed = timeElapsed+(Math.abs(currentButton - previousButton)+1)-(paralleTimeElapsed);
					paralleTimeElapsed = Math.abs(currentButton - previousButton)+1;
					previousBot = currentBot;
					previousButton = currentButton;
				}
				
				System.out.println(timeElapsed);
				System.out.println(paralleTimeElapsed);
			}
			
			
			
		
			
		String result = String.valueOf(timeElapsed);
			
			System.out.println("Case #"+(i+1)+": "+result);
			out.write("Case #"+(i+1)+": "+result + "\n");
			
		}
	}
}
