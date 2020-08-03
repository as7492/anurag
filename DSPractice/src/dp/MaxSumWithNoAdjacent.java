package dp;

public class MaxSumWithNoAdjacent {
	
	public static int findMaxSum(int[] arr, int n) {
		int excl = 0;
		int incl = arr[0];
		int currExcl = 0;
		
		for (int i = 1; i < arr.length; i++) {
			currExcl = incl > excl ? incl : excl;
			
			incl = excl+arr[i];
			
			excl = currExcl;
		}
		
		return incl > excl ? incl : excl;
	}
	
	

	public static void main(String[] args) {
		int arr[] = new int[]{5, 5, 10, 100, 10, 5}; 
        System.out.println(findMaxSum(arr, arr.length)); 
	}

}
