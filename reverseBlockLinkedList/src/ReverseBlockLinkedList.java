public class ReverseBlockLinkedList {
	
	
	static class Node{
		int value;
		Node nextNode;		
	}

	/**
	 * @param args
	 */
	static int[] list = new int[] { 3, 5, 6, 7, 12, 1, 8, 12 };
	static int blockSize = 0;
	static int blockCount = 0;
	static int noOfBlocks = 0;
	static Node head;
	static Node reversedLinkedListHead;

	public static void main(String[] args) {

		// Creating a linked list
		head = new Node();
		createLinkedList(head,0);
		
		
		Node n = new Node();
		n=head;
		while(n != null){
			System.out.print(n.value + " ");
			n = n.nextNode;
		}
		
		if (blockSize >= list.length) {
			blockSize = list.length;
		}
		if(blockSize==0){
			System.out.println("Block size cannot be zero");
			return;
		}
		
		System.out.println();
		noOfBlocks = (int) list.length / blockSize;
		n = head;
		for(int i=0;i<noOfBlocks;i++){
			Node x = new Node();
			
			for(int j=0;j<blockSize-1;j++){
				x.value = n.value;
				x.nextNode = n.nextNode;
				x = x.nextNode;
				n = n.nextNode;
			}
			
			
		}
		
		n=reversedLinkedListHead;
		while(n != null){
			System.out.print(n.value+ " ");
			n = n.nextNode;
		}
	}

	private static void createLinkedList(Node node,int i) {

		node.value = list[i];
		if((i+1)<list.length){
			createLinkedList(node.nextNode, (i+1));
		}
	}

	private static Node reverse(Node giveNode,Node reversedNode) {

		if(giveNode.nextNode == null){
			reversedNode.value = giveNode.value;
			return reversedNode;
		}else{
			Node n = new Node();
			n = reverse(giveNode.nextNode, reversedNode);
			n.nextNode = giveNode;
			n = n.nextNode;
			return n;
		}
	}

}
