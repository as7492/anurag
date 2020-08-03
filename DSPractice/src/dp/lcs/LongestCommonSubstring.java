package dp.lcs;

public class LongestCommonSubstring {
	
	public static int lcs(char[] x, int n, char[] y, int m) {
		
		int[][] matrix = new int[n+1][m+1];
		
		// In this case as part of base condition we will initialize first row and first column as 0
		// because we can have 0 lcs when any of the string is of size 0
		// as java has default value for integer 0, we do not need to do this step
		
		int result = 0;
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < m+1; j++) {
				if(x[i-1] == y[j-1]) {
					matrix[i][j] = 1+matrix[i-1][j-1];
					result = Math.max(result, matrix[i][j]);
				}else {
					matrix[i][j] = 0;
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		String x = "anurag";
		String y = "anucragsingh";
		
		int[][] matrix = new int[x.length()+1][y.length()+1];
		
		for(int i=0; i<=x.length(); i++) {
			for(int j=0; j<=x.length(); j++) {
				matrix[i][j] = -1;
			}
		}
		
		System.out.println(lcs(x.toCharArray(), x.length(), y.toCharArray(), y.length()));
	}

}
