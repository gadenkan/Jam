
public class test2 {

	public static void main(String [] args){
		
		System.out.println(updateBits(1000000000, 10101, 2, 6));

	}

	public static int updateBits(int n, int m, int i, int j) {
		int max = ~0; /* All 1’s */
		System.out.println("max: "+max);

		// 1’s through position j, then 0’s
		int left = max - ((1 << j) - 1);

		System.out.println("left: "+left);
		// 1’s after position i
		int right = ((1 << i) - 1);
		System.out.println("right: "+right);
		// 1’s, with 0s between i and j
		int mask = left | right;
		System.out.println("mask: "+mask);
		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}
}
