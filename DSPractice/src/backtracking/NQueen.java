package backtracking;

public class NQueen {
	
	public static boolean solve(int[][] board, int col) {
		
		if(col >= 4) {
			return true;
		}
		
		for(int k=0; k<4; k++) {
			if(isSafe(board, k, col)) {
				board[k][col] = 1;
				if(solve(board, col+1)) {
					return true;
				}else {
					board[k][col] = 0;
				}
			}
		}
		return false;
	}
	
	public static boolean isSafe(int[][] board, int row, int col) {
		int i,j;
		
		for(j=col; j>=0; j--) {
			if(board[row][j]==1) {
				return false;
			}
		}
		
		for(i=row,j=col; i>=0 && j>=0 ;i--,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		for(i=row,j=col; i<4 && j>=0 ;i++,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		int[][] board = new int[4][4];
		if(solve(board, 0)) {
			for (int i = 0; i < 4; i++) { 
	            for (int j = 0; j < 4; j++) 
	                System.out.print( 
	                    " " + board[i][j] + " "); 
	            System.out.println(); 
	        }
		}else {
			System.out.println("Not Possible");
		}
		
	}

}
