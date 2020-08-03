package dp.mcm;

public class MinPalindromePartitioning {

	public static int solve(char arr[], int i, int j) {

		if (i >= j) {
			return 0;
		}
		
		if(isPalindrome(arr,i,j)) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int k = i; k < j; k++) {
			int tempMin = solve(arr, i, k) + 
							solve(arr, k + 1, j) + 1;
			
			if(tempMin < min) {
				min = tempMin;
			}
		}
		
		return min;
	}
	
	public static int solveRec(char arr[], int i, int j, int[][] matrix) {

		if (i >= j) {
			return 0;
		}
		
		if(isPalindrome(arr,i,j)) {
			return 0;
		}
		
		if(matrix[i][j] != -1) {
			return matrix[i][j];
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int k = i; k < j; k++) {
			int tempMin = solveRec(arr, i, k, matrix) + 
					solveRec(arr, k + 1, j, matrix) + 1;
			
			if(tempMin < min) {
				min = tempMin;
			}	
		}
		matrix[i][j] = min;
		return matrix[i][j];
	}
	
	public static boolean isPalindrome(char[] arr, int i, int j) {
		while(i<j) {
			if(arr[i] != arr[j]) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "anurag";
		
		System.out.println(solve(str.toCharArray(), 0, str.length() - 1));
		
		// For Memoization
		int[][] matrix = new int[str.length()+1][str.length()+1];
		for (int i = 0; i < str.length()+1; i++) {
			for (int j = 0; j < str.length()+1; j++) {
				matrix[i][j] = -1;
			}
		}
		
		System.out.println(solveRec(str.toCharArray(), 0, str.length() - 1, matrix));
		
		
	}

}
