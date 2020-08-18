package backtracking;

public class RatMaze {
	
	static int rows[] = {1,0};
	static int cols[] = {0,1};
	
	public static boolean solve(int x, int y, int[][] maze, int[][] sol) {
		if(x == 3 && y == 3 && sol[x][y] == 1 && maze[x][y] == 1) {
			return true;
		}
		for(int i=0; i<2; i++) {
			if(isSafe(x+rows[i], y+cols[i], maze)) {
				sol[x+rows[i]][y+cols[i]] = 1;
				if(solve(x+rows[i], y+cols[i], maze, sol)) {
					return true;
				}else {
					sol[x+rows[i]][y+cols[i]] = 0;
				}
			}
		}
		return false;
	}
	
	public static boolean isSafe(int x, int y, int[][] maze) {
		return x>=0 && x<4 && y>=0 && y<4 && maze[x][y] == 1;
	}
	
	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 }, 
                		 { 1, 1, 0, 1 }, 
                		 { 0, 1, 0, 0 }, 
                		 { 1, 1, 1, 1 } }; 
		int sol[][] = new int[4][4];
		sol[0][0] = 1;
		
		if(solve(0, 0, maze, sol)) {
			for (int i = 0; i < 4; i++) { 
	            for (int j = 0; j < 4; j++) 
	                System.out.print( 
	                    " " + sol[i][j] + " "); 
	            System.out.println(); 
	        }
		}else {
			System.out.println("Not Possible");
		}
		
	}

}
