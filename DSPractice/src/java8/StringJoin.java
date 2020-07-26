package java8;

import java.util.ArrayList;
import java.util.List;

public class StringJoin {
	
	public static void main(String[] args) {
		System.out.println(String.join(",", "A","B","C"));
		
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		System.out.println(String.join(",", list));
	}

}
