package com.onmo.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		String string = "";
		List<String> arrayList = Arrays.asList(string.split(","));
		
		for(String string2 : arrayList){
			System.out.println(string2);
		}
		
		System.out.println(arrayList.size());
	}

}
