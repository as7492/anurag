package dp.knapsack.bounded;

public class AKnapsack {
	
	public static int getMapCapacityRec(int[] weight, int[] values, int n, int w) {
		if(n==0 || w ==0) {
			return 0;
		}
		if (weight[n - 1] <= w) {
			return Math.max(values[n - 1] + getMapCapacityRec(weight, values, n - 1, w - weight[n - 1]),
					getMapCapacityRec(weight, values, n - 1, w));
		} else {
			return getMapCapacityRec(weight, values, n - 1, w);
		}
	}
	
	public static int getMaxCapacity(int[] weight, int[] values, int n, int w) {
		
		int sum[][] = new int[n+1][w+1];
		// In this case as part of base condition we will initialize first row and first column as 0
		// because when we have capacity 0, then we can not put any weights which means max capacity will be 0;
		// and when we have no weights then also we can get max capacity as 0
		// as java has default value for integer 0, we do not need to do this step
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<w+1; j++) {
				if(weight[i-1] <= j) {
					sum[i][j] = Math.max(values[i-1] + sum[i-1][j-weight[i-1]], sum[i-1][j]);
				}else {
					sum[i][j] = sum[i-1][j];
				}
			}
		}
		
		return sum[n][w];
	}

	public static void main(String[] args) {
		int weight[] = {4,2,5,7,8,6};
		int values[] =  {3,2,4,6,4,2};
		int capacity = 20;
		
		
		int maxCapacity = getMaxCapacity(weight, values, weight.length, capacity);
		System.out.println(maxCapacity);
		
		maxCapacity = getMapCapacityRec(weight, values, weight.length, capacity);
		System.out.println(maxCapacity);
	}

}
