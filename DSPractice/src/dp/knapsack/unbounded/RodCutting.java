package dp.knapsack.unbounded;

public class RodCutting {
	
	//this is completely same as unbounded knapsack
	
	public static int getMaxProfitRec(int[] lenArr, int[] priceArr, int n, int w) {
		if(n==0 || w ==0) {
			return 0;
		}
		if (lenArr[n - 1] <= w) {
			return Math.max(priceArr[n - 1] + getMaxProfitRec(lenArr, priceArr, n, w - lenArr[n - 1]),
					getMaxProfitRec(lenArr, priceArr, n - 1, w));
		} else {
			return getMaxProfitRec(lenArr, priceArr, n - 1, w);
		}
	}
	
	public static int getMaxProfit(int[] lenArr, int[] priceArr, int n, int w) {
		
		int sum[][] = new int[n+1][w+1];
		// In this case as part of base condition we will initialize first row and first column as 0
		// because when we have capacity 0, then we can not put any weights which means max capacity will be 0;
		// and when we have no weights then also we can get max capacity as 0
		// as java has default value for integer 0, we do not need to do this step
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<w+1; j++) {
				if(lenArr[i-1] <= j) {
					sum[i][j] = Math.max(priceArr[i-1] + sum[i][j-lenArr[i-1]], sum[i-1][j]);
				}else {
					sum[i][j] = sum[i-1][j];
				}
			}
		}
		
		return sum[n][w];
	}

	public static void main(String[] args) {
		int lenArr[] = {4,2,5,7,8,6};
		int priceArr[] =  {3,2,4,6,4,2};
		int totalLen = 20;
		
		
		int maxProfit = getMaxProfit(lenArr, priceArr, lenArr.length, totalLen);
		System.out.println(maxProfit);
		
		maxProfit = getMaxProfitRec(lenArr, priceArr, lenArr.length, totalLen);
		System.out.println(maxProfit);
	}

}
