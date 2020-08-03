package dp.lcs;

public class LongestCommonSubsequence {
	
	
	public static int lcsRec(char[] x, int n, char[] y, int m) {
		if(n==0 || m==0) {
			return 0;
		}
		if(x[n-1] == y[m-1]) {
			return 1+lcsRec(x, n-1, y, m-1);
		}else {
			return Math.max(lcsRec(x, n, y, m-1), lcsRec(x, n-1, y, m));
		}
	}
	
	public static int lcsMemoized(char[] x, int n, char[] y, int m, int[][] matrix) {
		if(n==0 || m==0) {
			return 0;
		}
		if(matrix[n-1][m-1] != -1) {
			return matrix[n-1][m-1];
		}
		if(x[n-1] == y[m-1]) {
			matrix[n-1][m-1] = 1+lcsMemoized(x, n-1, y, m-1, matrix);
		}else {
			matrix[n-1][m-1] = Math.max(lcsMemoized(x, n, y, m-1, matrix), lcsMemoized(x, n-1, y, m, matrix));
		}
		return matrix[n-1][m-1];
	}
	
	public static int lcs(char[] x, int n, char[] y, int m) {
		
		int[][] matrix = new int[n+1][m+1];
		
		// In this case as part of base condition we will initialize first row and first column as 0
		// because we can have 0 lcs when any of the string is of size 0
		// as java has default value for integer 0, we do not need to do this step
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < m+1; j++) {
				if(x[i-1] == y[j-1]) {
					matrix[i][j] = 1+matrix[i-1][j-1];
				}else {
					matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
				}
			}
		}
		return matrix[n][m];
	}
	
	public static void main(String args[]) {
		String x = "anurag";
		String y = "auvhjsg";
		
		int[][] matrix = new int[x.length()+1][y.length()+1];
		
		for(int i=0; i<=x.length(); i++) {
			for(int j=0; j<=x.length(); j++) {
				matrix[i][j] = -1;
			}
		}
		
		System.out.println(lcsRec(x.toCharArray(), x.length(), y.toCharArray(), y.length()));
		
		System.out.println(lcsMemoized(x.toCharArray(), x.length(), y.toCharArray(), y.length(), matrix));
		
		System.out.println(lcs(x.toCharArray(), x.length(), y.toCharArray(), y.length()));
	}

}
