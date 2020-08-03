package dp;

public class ScrambledString {
	

	public static boolean isScramble(String S1, String S2) 
	{ 
		if (S1.length() != S2.length()) { 
			return false; 
		} 

		int n = S1.length(); 

		if (n == 0) { 
			return true; 
		} 

		if (S1.equals(S2)) { 
			return true; 
		}

		for (int i = 1; i < n; i++) { 

			if (isScramble(S1.substring(0, i), S2.substring(0, i)) 
				&& isScramble(S1.substring(i), S2.substring(i))) { 
				return true; 
			} 

			if (isScramble(S1.substring(0, i), S2.substring(n - i)) 
				&& isScramble(S1.substring(i), S2.substring(0, n-i))) { 
				return true; 
			} 
		} 

		return false; 
	} 

	// Driver Code 
	public static void main(String args[]) 
	{ 
		String S1 = "coder"; 
		String S2 = "ocred"; 

		if (isScramble(S1, S2)) { 
			System.out.println("Yes");
		} 
		else { 
			System.out.println("No"); 
		} 
	} 

}
