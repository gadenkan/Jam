import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class test {

	public static void main(String[] args){

		Vector v = new Vector<String>();
		v.add("When riding your bicycle backwards down a one-way street, if the");
		v.add("wheel falls of a canoe, how many ball bearings does it take to fill");
		v.add("up a water buffalo?");
		v.add("Hello Howard.");

		//printMostFrequentWords(v);

		//constructTree("NNNLLLNNLLL");
		test t = new test();
		isListPalindrome(t.new Node());
		
	}

	class Node {
		Node next;
		int val;
	};
	static Integer isListPalindrome(Node head) {
		
		List l= new ArrayList();
		List l2 = new ArrayList();
		
		f(l, l2, head);

		for(int i=0; i<l.size(); i++){ 
			if (l.get(i) != l2.get(i))
				return 0;
		}
		return 1;
	}

	static void f(List l, List l2, Node head) {
		if(head instanceof Node){

			l.add(head.val);
			f(l, l2, head.next);
			l2.add(head.val);
		}
	}



	/*
	class Node {
		Node left, right;
		char val;
		Node() {
			left = right = null;
		}
	}

	static int  index=0;
	static test t = new test();
	static Node constructTree(String preorder) {


		Node n = t.new Node();

		if(index >= preorder.length()){
			return null;
		}
		if(preorder.charAt(index) == 'L'){
			n.val='L';
			n.left = null;
			n.right = null;
			index++;
			//System.out.print(n.val);
			return n;
		}
		if(preorder.charAt(index) == 'N'){
			n.val='N';
			index++;
			//System.out.print(n.val);
			n.left = constructTree(preorder);
			n.right = constructTree(preorder);

			return n;
		}
		return null;		
	}*/




	/*static void printMostFrequentWords(Vector<String >a) {


		for(int i=0;i<a.size();i++){
			int max=0;
			int[] arr = new int[52];
			char[] cArr = a.get(i).toCharArray();
			for(int j=0;j<cArr.length;j++){
				if(cArr[j]>64 && cArr[j]<91)
					arr[ cArr[j]- 'A']++;

				if(cArr[j]>96 && cArr[j]<123)
					arr[ 26 + cArr[j]- 'a']++;
			}

			for(int k=0;k<arr.length;k++){
				if(arr[k] > max)
					max = arr[k];
			}

			for(int k=0;k<arr.length;k++){
				if(arr[k] == max){
					if(k<26){
						char[] c= Character.toChars(k+65);
						System.out.print(c[0]);
					}
					else{
						char[] c= Character.toChars(k-26+97);
						System.out.print(c[0]);
					}
				}	
			}
			System.out.println(" "+max);
		}



	}*/

}
