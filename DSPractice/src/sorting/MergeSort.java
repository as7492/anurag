package sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static void sort(int arr[],int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			
			sort(arr, left, mid);
			sort(arr, mid+1, right);
			merge(arr, left, mid, right);
			
		}
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int[] leftArray = new int[mid-left+1];
		int[] rightArray = new int[right-mid];
		
		int index = left;
		for(int i=0; i<leftArray.length; i++) {
			leftArray[i]= arr[index];
			index++;
		}
		for(int i=0; i<rightArray.length; i++) {
			rightArray[i]= arr[index];
			index++;
		}
		
		int i = 0,j = 0;
		index = left;
		while(i<leftArray.length && j<rightArray.length) {
			if(leftArray[i] < rightArray[j]) {
				arr[index] = leftArray[i];
				i++;
			}else {
				arr[index] = rightArray[j];
				j++;
			}
			index++;
		}
		
		while(i<leftArray.length) {
			arr[index] = leftArray[i];
			i++;
			index++;
		}
		
		while(j<rightArray.length) {
			arr[index] = rightArray[j];
			j++;
			index++;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 7, 8, 9, 2, 4, 1, 6 };
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
