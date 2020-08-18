package backtracking;

import java.util.Arrays;

public class KnightTour {
	static int[] rows = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] cols = {-1,  1,  2, -2, 2,-2, 1,-1};
	
	public static boolean solveKnightTour(int x, int y, int move, int[][] sol) {
		System.out.println(move);
		if(move == 64) {
			return true;
		}
		for(int k=0; k<8; k++) {
			if(isSafe(x+rows[k], y+cols[k], sol)) {
				
				sol[x+rows[k]][y+cols[k]] = move;
				
				if(solveKnightTour(x+rows[k], y+cols[k], move+1, sol)) {
					return true;
				}else {
					sol[x+rows[k]][y+cols[k]] = -1;
				}
			}
		}
		return false;
	}
	
	public static boolean isSafe(int x, int y, int[][] sol) {
		if(x >= 0 && x < 8 && y >= 0 && y < 8 && sol[x][y] == -1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		int[][] sol = new int[8][8];
		
		for (int x = 0; x < 8; x++) 
            for (int y = 0; y < 8; y++) 
                sol[x][y] = -1; 
		
		if(!solveKnightTour(0, 0, 1, sol)) {
			System.out.println("No Solution");
		}else {
			System.out.println(Arrays.toString(sol));
		}
	}

}
