public class ReverseBlockArray {

	/**
	 * @param args
	 */

	static int[] list = new int[] { 3, 5, 6, 7, 12, 1, 8, 12 };
	static int blockSize = 3;
	static int blockCount = 0;
	static int noOfBlocks = 0;

	public static void main(String[] args) {

		if (blockSize >= list.length) {
			blockSize = list.length;
		}
		if(blockSize==0){
			System.out.println("Block size cannot be zero");
			return;
		}
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		noOfBlocks = (int) list.length / blockSize;
		reverseBlock(0);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

	private static void reverseBlock(int i) {

		for (int k =0; k < blockSize/2 ; k++) {
			System.out.println(list[i+k]);
			int temp = list[i+k];
			list[i+k] = list[i+blockSize-1-k];
			list[i+blockSize-1-k] = temp;
			System.out.println(list[i+k]);
		}
		
		blockCount++;
		if(blockCount < noOfBlocks){
			reverseBlock(i+blockSize);
		}

	}
}
