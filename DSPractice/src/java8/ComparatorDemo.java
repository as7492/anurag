package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("E");
		list.add("C");
		list.add("D");
		
		list.sort(Comparator.comparing(string -> string));
		
		list.stream().forEach(string -> System.out.println(string));

	}

}
