package dp.knapsack.bounded;

public class DEqualSumPartition {
	
	public static boolean checkEqualPartition(int[] arr) {
		int sum = 0;
		for(int i : arr) {
			sum = sum+i;
		}
		
		if(sum%2!=0) {
			return false;
		}else {
			return BSubsetSum.hasSubsetSum(arr, arr.length, sum/2);
		}
	}

	public static void main(String[] args) {

		int arr[] = {4,2,5,7,8,6};
		
		System.out.println(checkEqualPartition(arr));
	}

}
