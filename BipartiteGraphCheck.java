package Personal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphCheck {
	
	static int V = 4;

	public static void main(String[] args) {
		
		 int G[][] = {
				 	{0, 1, 0, 1},
		            {1, 0, 1, 0},
		            {0, 1, 0, 1},
		            {1, 0, 1, 0}
		        };
		 
		if(isBipartite(G))
			System.out.println("Bipartite");
		else
			System.out.println("Not a bipartite");
	}
	
	static boolean isBipartite(int G[][])
	{
		boolean ans = true;
		
		int color[] = new int[V];
		Arrays.fill(color,-1);
		
		for(int v=0; v<V; v++)
		{
			if(color[v]==-1)
			{
				ans = ans & isBipartite(G,v,color);
			}
		}
		
		return ans;
	}
	
	static boolean isBipartite(int G[][], int src, int[] color)
	{
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(src);
		while(!q.isEmpty())
		{
			int temp = q.peek();
			q.remove();
			
			int c = color[temp];
			
			for(int i=0; i<V; i++)
			{
				if(temp!=i)
				{
					if(G[temp][i]==1 && color[i]==-1)
					{
						color[i] = 1-c;
						q.add(i);
					}
					else if(G[temp][i]==1 && color[i]==c)
					{
						return false;
					}
				}
			}
		}
		
		return true;
	}

}
