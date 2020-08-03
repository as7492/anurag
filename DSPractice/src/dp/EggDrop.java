package dp;

public class EggDrop {
	
	public static int solve(int f, int e) {
		if(f <= 1) {
			return f;
		}
		if(e == 1) {
			return f;
		}
		int min = Integer.MAX_VALUE;
		
		for(int k=1; k<=f; k++) {
			int tempMin = 1+ Math.max(solve(k-1, e-1), solve(f-k, e));
			if(tempMin < min) {
				min = tempMin;
			}
		}
		return min;
	}
	
	public static int solveMem(int f, int e, int[][] matrix) {
		if(f <= 1) {
			return f;
		}
		if(e == 1) {
			return f;
		}
		
		if(matrix[f][e] != -1) {
			return matrix[f][e];
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int k=1; k<=f; k++) {
			int tempMin = 1+ Math.max(solveMem(k-1, e-1, matrix), solveMem(f-k, e, matrix));
			if(tempMin < min) {
				min = tempMin;
			}
		}
		matrix[f][e] = min;
		return min;
	}

	public static void main(String[] args) {
		int floors = 25;
		int eggs = 5;
		
		
		
		int[][] matrix = new int[floors+1][eggs+1];
		
		for (int i = 0; i < floors+1; i++) {
			for (int j = 0; j < eggs+1; j++) {
				matrix[i][j] = -1;
			}
		}
		
		System.out.println(solveMem(floors, eggs, matrix));
		
		System.out.println(solve(floors, eggs));
 		
		
	}

}
