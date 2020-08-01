package matrix;

public class Islands {
	
	public static int countIslands(int[][] mat, int rows, int cols) {
		boolean[][] visited = new boolean[rows][cols];
		int count = 0;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(mat[i][j] == 1 && !visited[i][j]) {
					check(mat, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void check(int[][] mat, int r, int c, boolean[][] visited) {
		int[] rows = {-1,-1,-1,0,0,1,1,1};
		int[] cols = {-1,0,1,-1,1,-1,0,1};
		
		visited[r][c] = true;
		
		for(int k=0; k<8; k++) {
			if(r+rows[k]>=0 && r+rows[k]<5 && c+cols[k]>=0 && c+cols[k]<5 && mat[r+rows[k]][c+cols[k]] == 1 && !visited[r+rows[k]][c+cols[k]]) {
				check(mat, r+rows[k], c+cols[k], visited);
			}
		}
	}

	public static void main(String[] args) {
		int mat[][] = new int[][] { { 1, 1, 0, 0, 0 }, 
            					  { 0, 1, 0, 0, 1 }, 
            					  { 1, 0, 0, 1, 1 }, 
            					  { 0, 0, 0, 0, 0 }, 
            					  { 1, 0, 1, 0, 1 } }; 
            
		System.out.println("Number of islands is: " + countIslands(mat, 5, 5)); 

	}

}
