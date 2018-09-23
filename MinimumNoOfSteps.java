package Personal;

public class MinimumNoOfSteps {

	public static void main(String[] args) {

		int mat[][] = {
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,0},
				{0,0,1,0,0,0,0,0},
				{0,0,0,0,1,0,0,0},
				{0,1,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0}};
		
		int x = minSteps(mat,7,0,2,5,new int[8][8],0);

	}

	private static int minSteps(int[][] mat, int row, int col, int destRow, int destCol, int[][] memo, int dist) {
		
		if(isSafe(mat,row,col))
		{
			if((row==destRow)&&(col==destCol))
				return 0;
			
			if(memo[row][col]>0 && memo[row][col]!=Integer.MAX_VALUE)
				return memo[row][col];
			
			int steps = 0;
			
			steps = 				1 + minSteps(mat,row-2,col-1,destRow,destCol,memo,dist+1) ;
			steps = 1 + Math.min(steps, minSteps(mat,row-2,col+1,destRow,destCol,memo,dist+1));
			steps = 1 + Math.min(steps, minSteps(mat,row+2,col-1,destRow,destCol,memo,dist+1));
			steps = 1 + Math.min(steps, minSteps(mat,row+2,col+1,destRow,destCol,memo,dist+1));
			steps = 1 + Math.min(steps, minSteps(mat,row-1,col+2,destRow,destCol,memo,dist+1));
			steps = 1 + Math.min(steps, minSteps(mat,row+1,col+2,destRow,destCol,memo,dist+1));
			steps = 1 + Math.min(steps, minSteps(mat,row-1,col-2,destRow,destCol,memo,dist+1));
			steps = 1 + Math.min(steps, minSteps(mat,row+1,col-2,destRow,destCol,memo,dist+1));
			
			System.out.println("Distance : ");
			memo[row][col] = steps;
			return steps;
		}
		
		return Integer.MAX_VALUE;
	}

	private static boolean isSafe(int[][] mat, int row, int col) {
		
		if(row<0 || row>=mat.length || col<0 || col>=mat[0].length)
			return false;
		
		if(mat[row][col]==1)
			return false;
		
		return true;
	}

}
