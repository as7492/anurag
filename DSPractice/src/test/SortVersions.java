package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortVersions {

	public static void main(String[] args) {
		String[] arr = {"1.2.34", "$5.j8", "3.4#", "3.45", "123", ".32"};
		
		List<String> list = new ArrayList<String>();
		
		for(String str : arr) {
			if(Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(str.length()-1)) && str.matches("[0-9||.]+")) {
				list.add(str);
			}
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] arr1 = o1.split(".");
				String[] arr2 = o2.split(".");
				
				if(arr1.length > arr2.length) {
					int i = 0;
					for(i =0; i<arr2.length; i++) {
						if(Integer.parseInt(arr1[i]) == Integer.parseInt(arr2[i])) {
							continue;
						}else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
							return 1;
						}else {
							return -1;
						}
					}
					if(i < arr1.length) {
						if(Integer.parseInt(arr1[i]) > 0) {
							return 1;
						}
						i++;
					}
					
				}else {
					int i = 0;
					for(i =0; i<arr1.length; i++) {
						if(Integer.parseInt(arr1[i]) == Integer.parseInt(arr2[i])) {
							continue;
						}else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
							return 1;
						}else {
							return -1;
						}
					}
					if(i < arr2.length) {
						if(Integer.parseInt(arr2[i]) > 0) {
							return -1;
						}
						i++;
					}
					
				}
				return 0;
			}
			
		});
		System.out.println(list);
	
	}

}
