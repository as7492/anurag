package dp.lcs;

public class PrintLongestCommonSubsequence {
	
	//https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23
	
	public static String printlcs(char[] x, int n, char[] y, int m) {
		
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
		
		
		String result = "";
		
		int i=n;
		int j=m;
		while(i>0 && j>0) {
			if(x[i-1] == y[j-1]) {
				result = result+x[i-1];
				i--;
				j--;
			}else {
				if(matrix[i-1][j] > matrix[i][j-1]) {
					i--;
				}else {
					j--;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String args[]) {
		String x = "abcd";
		String y = "auvhjsg";
		
		String revlcs = printlcs(x.toCharArray(), x.length(), y.toCharArray(), y.length());
		StringBuilder builder = new StringBuilder(revlcs);
		builder.reverse();
		
		System.out.println(builder.toString());
	}

}
