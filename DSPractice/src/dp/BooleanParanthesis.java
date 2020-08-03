package dp;

public class BooleanParanthesis {

	public static boolean solve(char arr[], int i, int j, boolean flag) {
		return false;
	}

	public static void main(String[] args) {
		String str = "T|F^T&F";
		System.out.println(solve(str.toCharArray(), 0, str.length() - 1, true));
	}

}
