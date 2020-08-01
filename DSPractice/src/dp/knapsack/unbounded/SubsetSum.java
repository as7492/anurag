package dp.knapsack.unbounded;

public class SubsetSum {
	
	
	public static boolean hasSubsetSumRec(int[] arr, int n, int sum) {
		if(sum == 0) {
			return true;
		}
		if(n == 0) {
			return false;
		}
		
		if(arr[n-1] <= sum) {
			return hasSubsetSum(arr, n-1, sum-arr[n-1]) || hasSubsetSum(arr, n-1, sum);
		}else {
			return hasSubsetSum(arr, n-1, sum);
		}
	}
	
	public static boolean hasSubsetSum(int[] arr, int n, int sum) {
		boolean[][] result = new boolean[n+1][sum+1];
		
		// when sum is 0 then we can have subset in array with any length i.e. empty array as subset
		// we will fill up first column with value true
		for(int i=0; i<n+1; i++) {
			result[i][0]=true;
		}
		
		// when array is empty then we cannot for subset of any sum except sum 0
		// we will fill up first row as false
		// but as java has default value false for boolean, this needs not to be done
		
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(arr[i-1] <= j) {
					result[i][j] = result[i-1][j-arr[i-1]] || result[i-1][j];
				}else {
					result[i][j] = result[i-1][j];
				}
			}
		}
		return result[n][sum];
	}
	
	

	public static void main(String[] args) {
		int arr[] = {4,2,5,7,8,6};
		int sum = 10;
		
		
		System.out.println(hasSubsetSum(arr, arr.length, sum));
		
		System.out.println(hasSubsetSumRec(arr, arr.length, sum));
		
	}

}
