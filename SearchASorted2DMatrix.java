package Personal;

import java.util.*;
import java.io.*;

class SearchASorted2DMatrix {
	public static void main (String[] args) {
		
		int n=4, m=4;
		int ar[][] =  {{10, 20, 30, 40},
                	   {15, 25, 35, 45},
                	   {27, 29, 37, 48},
                	   {32, 33, 39, 50}};
		
		find(ar,n,m,37);        
	}
	
	static void find(int ar[][], int n, int m, int key)
	{
		int i=0, j=m-1;
		while(i<m && j>=0)
		{
			if(ar[i][j]==key)
			{
				System.out.println("Element found at ("+i+","+j+")");
				break;
			}
			else if(ar[i][j]<key)
				i++;
			else
				j--;
		}
		
	   if(i==n || j==0)
		   System.out.println("Not Found!!");
	}
}
