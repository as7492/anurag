package sorting;

import java.util.Arrays;

public class HeapSort {
	
	public static void sort(int[] arr, int n) {
		for(int i=(n/2)-1; i>=0; i--) {
			heapify(arr, i, n);
		}
		
		for(int i=n-1; i>0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, 0, i);
		}
		
	}
	
	public static void heapify(int[] arr, int i, int n) {
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		
		if(left<n && arr[left]>arr[largest]) {
			largest = left;
		}
		if(right<n && arr[right]>arr[largest]) {
			largest = right;
		}
		
		if(largest!=i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, largest, n);
		}
		
	}
	
	public static void main(String args[]) {
		int[] arr = { 5, 3, 7, 8, 9, 2, 4, 1, 6 };
		sort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
}
