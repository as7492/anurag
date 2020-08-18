package array;

import java.util.Arrays;

public class SeggregateThreeNum {
	
	public static void sort(int[] arr) {
		
		int l = 0;
		int r = arr.length-1;
		int m = 0;
		
		while(m<=r) {
			if(arr[m] == 1) {
				int temp = arr[m];
				arr[m] = arr[l];
				arr[l] = temp;
				l++;
				m++;
			}else if(arr[m] == 3) {
				int temp = arr[m];
				arr[m] = arr[r];
				arr[r] = temp;
				r--;
			}else {
				m++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {2,1,1,3,2,2,3,1,2,3,1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
