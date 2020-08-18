package array;

import java.util.Arrays;

public class RotateArray {

	public static void rotateArray(int[] arr, int d) {
		while(d>0) {
			int temp = arr[0];
			for (int i = 0; i < arr.length-1; i++) {
				arr[i] = arr[i+1];
			}
			arr[arr.length-1]=temp;
			d--;
		}
	}
	
	public static void blockSwap(int[] arr, int d) {
		reverseArray(arr, 0, d-1);
		reverseArray(arr, d, arr.length-1);
		reverseArray(arr, 0, arr.length-1);
	}
	
	public static void reverseArray(int[] arr, int start, int end) {
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int d = 2;
		rotateArray(arr, d);
		System.out.println(Arrays.toString(arr));
		blockSwap(arr, d);
		System.out.println(Arrays.toString(arr));
	}
}
