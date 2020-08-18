package dp.knapsack.bounded;

public class FMinimumSubsetSumDiff {
	
	public static int minSubsetSumDiff(int[] arr, int n, int range) {
		boolean[][] result = new boolean[n+1][range+1];
		
		// when sum is 0 then we can have subset in array with any length i.e. empty array as subset
		// we will fill up first column with value true
		for(int i=0; i<n+1; i++) {
			result[i][0]=true;
		}
		
		// when array is empty then we cannot for subset of any sum except sum 0
		// we will fill up first row as false
		// but as java has default value false for boolean, this needs not to be done
		
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<range+1; j++) {
				if(arr[i-1] <= j) {
					result[i][j] = result[i-1][j-arr[i-1]] || result[i-1][j];
				}else {
					result[i][j] = result[i-1][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int j=0; j<=range/2; j++) {
			if(result[n][j]) {
				min = range-(2*j) < min ? range-(2*j) : min;
			}
		}
		return min;
	}
	
	

	public static void main(String[] args) {
		int arr[] = {1, 6, 11, 5};
		
		int range = 0;
		for(int i : arr) {
			range= range + i;
		}
		
		System.out.println(minSubsetSumDiff(arr, arr.length, range));
		
		
	}

}
