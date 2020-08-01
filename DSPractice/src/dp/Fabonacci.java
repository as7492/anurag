package dp;

public class Fabonacci {
	
	public static int findFab(int n) {
		int[] sum = new int[n+1];
		sum[1] = 0;
		sum[2] = 1;
		
		for(int i=3; i<=n; i++) {
			sum[i] = sum[i-1]+sum[i-2];
		}
		
		return sum[n];
	}

	public static void main(String[] args) {
		System.out.println(findFab(2));

	}

}
