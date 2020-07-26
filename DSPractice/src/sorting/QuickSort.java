package sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static void sort(int arr[], int left, int right) {
		if(left<right) {
			int pivot = findPivot(arr, left, right);
			sort(arr, left, pivot-1);
			sort(arr, pivot+1, right);
		}
	}
	
	public static int findPivot(int[] arr, int left, int right) {
		int i = left;
		while(left<right) {
			if(arr[left] < arr[right]) {
				int temp = arr[i];
				arr[i] = arr[left];
				arr[left] = temp;
				i++;
			}
			left++;
		}
		int temp = arr[i];
		arr[i] = arr[right];
		arr[right] = temp;
		
		return i;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 7, 8, 9, 2, 4, 1, 6 };
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
