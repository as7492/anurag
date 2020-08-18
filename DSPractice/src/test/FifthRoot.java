package test;

//A Java program to find 
//floor of 5'th root 

class FifthRoot { 
	
	// Returns floor of 5'th 
	// root of n 
	static int floorRoot5(int n) 
	{ 
		
		// Base cases 
		if (n == 0 || n == 1) 
		return n; 
	
		// Do Binary Search for 
		// floor of 5th square root 
		int low = 1, high = n, ans = 0; 
		while (low <= high) 
		{ 
			
			// Find the middle point 
			// and its power 5 
			int mid = (low + high) / 2; 
			long mid5 = mid * mid * mid * 
							mid * mid; 
	
			// If mid is the required root 
			if (mid5 == n) 
				return mid; 
	
			// Since we need floor, 
			// we update answer when 
			// mid5 is smaller than n, 
			// and move closer to 
			// 5'th root 
			if (mid5 < n) 
			{ 
				low = mid + 1; 
				ans = mid; 
			} 
			
			// If mid^5 is greater 
			// than n 
			else
				high = mid - 1; 
		} 
		return ans; 
	} 
	
	// Driver Code 
	public static void main(String []args) 
	{ 
		int n = 32; 
		System.out.println("Floor of 5'th root is " + 
									floorRoot5(n)); 
	} 
} 

//This code is contributed by Anshul Aggarwal. 

