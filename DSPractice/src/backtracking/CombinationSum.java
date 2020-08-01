package backtracking;

public class CombinationSum {
	
	public class Int{
		int count = 0;
	}
	
	public static void combinationCount(int k, int sum, Int count, int startFrom) {
		
		if(sum < 0) {
			return;
		}else if(sum == 0) {
			count.count++;
			return;
		}
		
		for(int i=startFrom; i<=k; i++) {
			combinationCount(k, sum-i, count, i);
		}
	}
	

	public static void main(String[] args) {
		Integer k = 2;
		int sum = 8;
		CombinationSum c = new CombinationSum();
		Int count = c.new Int();
		
		combinationCount(k, sum, count, 1);
		
		System.out.println(count.count);
		
	}

}
