
public class ReverseWholeLinkedList {

	static class Node{
		int value;
		Node nextNode;
	}

	/**
	 * @param args
	 */
	static int[] list = new int[] { 3, 5, 6, 7, 12, 1, 8, 12 };
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
		
		System.out.println();
		reversedLinkedListHead = new Node(); 
		Node lastNode = reverse(head,reversedLinkedListHead);
		lastNode.nextNode = null;
		
		n=reversedLinkedListHead;
		while(n != null){
			System.out.print(n.value+ " ");
			n = n.nextNode;
		}
	}

	private static void createLinkedList(Node node,int i) {

		node.value = list[i];
		
		if((i+1)<list.length){
			node.nextNode = new Node();
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
