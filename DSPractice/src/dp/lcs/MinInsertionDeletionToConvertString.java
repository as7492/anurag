package dp.lcs;

public class MinInsertionDeletionToConvertString {
	
	//https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
	
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
		int lcs = lcs(x.toCharArray(), x.length(), y.toCharArray(), y.length());
		int deletion = x.length()-lcs;
		int insertion = y.length()-lcs;
		
		System.out.println("Deletion : "+deletion);
		System.out.println("Insertion : "+insertion);
	}

}
