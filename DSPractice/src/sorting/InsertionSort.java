package sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void sort(int[] arr, int n) {

		int temp = 0;
		for (int i = 1; i < n; i++) {
			int currIndex = i;
			while(currIndex > 0 && arr[currIndex] < arr[currIndex-1]) {
				temp = arr[currIndex];
				arr[currIndex] = arr[currIndex-1];
				arr[currIndex-1] = temp;
				currIndex--;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 7, 8, 9, 2, 4, 1, 6 };
		sort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
