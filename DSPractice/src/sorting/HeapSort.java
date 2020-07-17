package sorting;

import java.util.Arrays;

public class HeapSort {
	
	public static void sort(int[] arr, int n) {
		for(int i=n/2-1; i>=0; i--) {
			heapify(arr, i, n);
		}
		
		for (int i=n-1; i>0; i--) 
        { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            heapify(arr, 0, i); 
        } 
	}
	
	public static void heapify(int[] arr, int i, int n) {
		int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2; 
  
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
            heapify(arr, n, largest); 
        } 
		
	}

	public static void main(String[] args) {
		int[] arr = {5,3,7,8,9,2,4,1,6};
		sort(arr, arr.length);
		
		System.out.println(Arrays.toString(arr));
		
	}

}
