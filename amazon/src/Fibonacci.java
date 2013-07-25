
public class Fibonacci {

	public static int[] arr;
	public static void main(String[] args){
		int n=10;
		arr = new int[n];
		int a = displayFibo(n-1);
		for(int x:arr){
			System.out.println(x);
		}
	}

	private static int displayFibo(int i) {

		if(arr[i]>0){
			return arr[i];
		}
		int fiboVal = 0;
		if(i==0)
			return 0;
		else if(i==1){
			arr[i] = 1;
			return 1;
		}
		else{
			fiboVal = displayFibo(i-1) + displayFibo(i-2);
			//System.out.println(fiboVal);
			arr[i] = fiboVal;
			return fiboVal;
		}
		
	}
	
	
}
