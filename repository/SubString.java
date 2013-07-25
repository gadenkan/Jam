package repository;

import java.util.ArrayList;
import java.util.List;

public class SubString {
	static String name = "my name is";
	static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args){
		
		for (int i=0; i<name.length();i++){
			System.out.println(name.substring(i,i+1));
			list.add(name.substring(i,i+1));
		}
		System.out.println(list);
		System.out.println(list.removeAll(list));
		System.out.println(list);
	}

}
