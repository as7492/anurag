package dp.knapsack.bounded;

public class CombinationSum {
	
	//Also use this for Coin Change Problem : Maximum Number of ways
	
	public static int countCombinationSumRec(int[] arr, int n, int sum) {
		if(sum == 0) {
			return 1;
		}
		if(n == 0) {
			return 0;
		}
		
		if(arr[n-1] <= sum) {
			return countCombinationSumRec(arr, n, sum-arr[n-1]) + countCombinationSumRec(arr, n-1, sum);
		}else {
			return countCombinationSumRec(arr, n-1, sum);
		}
	}
	
	public static int countCombinationSum(int[] arr, int n, int sum) {
		int[][] result = new int[n+1][sum+1];
		
		// when sum is 0 then we can have one subset in array with any length i.e. empty array as subset
		// we will fill up first column with value 1
		for(int i=0; i<n+1; i++) {
			result[i][0]=1;
		}
		
		// when array is empty then we cannot for subset of any sum except sum 0
		// we will fill up first row as 0
		// but as java has default value 0 for integer, this needs not to be done
		
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(arr[i-1] <= j) {
					result[i][j] = result[i][j-arr[i-1]] + result[i-1][j];
				}else {
					result[i][j] = result[i-1][j];
				}
			}
		}
		return result[n][sum];
	}
	
	

	public static void main(String[] args) {
		int arr[] = {1,2,3};
		int sum = 5;
		
		
		int count = countCombinationSum(arr, arr.length, sum);
		System.out.println(count);
		
		count = countCombinationSumRec(arr, arr.length, sum);
		System.out.println(count);
	}

}
