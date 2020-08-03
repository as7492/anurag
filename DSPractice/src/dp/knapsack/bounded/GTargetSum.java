package dp.knapsack.bounded;

public class GTargetSum {

	public static void main(String[] args) {
		
		
		// Its the same problem as subsets with given difference as in that also we are doing following things 
		// subset1 elements is assigned positive sign whereas subset2 elements got assigned with negative signs
		int arr[] = { 4, 2, 5, 7, 8, 6 };
		int diff = 3;
		
		int sum = 0;
		for(int i : arr) {
			sum = sum + i;
		}
		
		//sum of subset1 + sum of subset2 = sum
		//sum of subset1 - sum of subset2 = diff
		//so adding above 2 equations, sunset1 = (sum+diff)/2
		
		int sumSubset1 = (sum+diff)/2;
		

		System.out.println(CCountSubsetSum.countSubsetSum(arr, arr.length, sumSubset1));}

}
