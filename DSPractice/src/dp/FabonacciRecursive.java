package dp;

public class FabonacciRecursive {
	
	public static int fab(int n) {
		if(n<=1) {
			return 1;
		}
		return fab(n-1)+fab(n-2);
	}
	

	public static void main(String[] args) {
		System.out.println(fab(4));
	}

}
