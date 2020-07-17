package sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void sort(int[] arr, int n) {

		int temp = 0;
		int smallIndex = 0;

		for (int i = 0; i < n; i++) {
			smallIndex = i;
			for (int j = i; j < n; j++) {
				if (arr[j] < arr[smallIndex]) {
					smallIndex = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[smallIndex];
			arr[smallIndex] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 7, 8, 9, 2, 4, 1, 6 };
		sort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
