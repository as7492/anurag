package sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void sort(int[] arr, int n) {

		int temp = 0;
		boolean swap = false;
		for (int i = 0; i < n; i++) {
			swap = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j + 1] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swap = true;
				}
			}
			if (!swap) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 7, 8, 9, 2, 4, 1, 6 };
		sort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
