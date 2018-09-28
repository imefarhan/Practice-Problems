package Personal;

import java.util.Arrays;

public class mColoringGraphProblem {
	
	static int V = 4;

	public static void main(String[] args) {
		
		int graph[][] = {{0, 1, 1, 1}, 
	            {1, 0, 1, 0}, 
	            {1, 1, 0, 1}, 
	            {1, 0, 1, 0}, 
	        }; 
	        int m = 3; // Number of colors 
	        graphColoring(graph, m);

	}
	
	static void graphColoring(int G[][], int m)
	{
		int color[] = new int[V];
		
		if(graphColoring(G,color,m,0)==true)
		{
			System.out.println("The graph can be colored.");
			System.out.println(Arrays.toString(color));
		}
		else
		{
			System.out.println("The graph cannot be colored.");
		}
	}

	private static boolean graphColoring(int[][] G, int[] color, int m, int v) {
		
		if(v==V)
			return true;
		
		for(int c=1; c<=m; c++)
		{
			if(canBeColored(G,color,v,c))
			{
				color[v] = c;
				
				if(graphColoring(G,color,m,v+1))
					return true;
				
				//backtracking
				color[v] = 0;
			}
		}
		
		return false;
	}

	private static boolean canBeColored(int[][] G, int[] color, int v, int c) {
		
		for(int i=0; i<V; i++)
		{
			if(G[v][i]==1 && color[i]==c)
				return false;
		}
		
		return true;
	}

}
