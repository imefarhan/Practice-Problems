package Personal;

import java.util.Scanner;

public class Mooshak {
	
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the No of rows :");
		n= sc.nextInt();
		
		int ar[][] = new int[n][n];
		
		System.out.println("Enter the elements :");
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				ar[i][j] = sc.nextInt();
		
		
		if(path(ar))
			System.out.println("Path available");
		else
			System.out.println("Path not Available");
	}
	
	/*
INPUT:

1 0 0 0 1 0
1 1 1 0 1 0
0 0 1 1 1 0
0 0 0 0 1 0
0 0 9 0 1 0
0 0 0 0 1 1

	 */
	
	static boolean path(int ar[][])
	{
		return path(ar,0,0);
	}

	
	static boolean path(int ar[][], int i, int j)
	{
		if(i<0 || i>ar.length-1 || j<0 || j>ar.length-1)
			return false;
		
		if(ar[i][j]==9)
			return true;
		
		if(ar[i][j]!=1)
			return false;
		
		if(ar[i][j]==1)
			ar[i][j]=3;
		
		//up
		if(path(ar,i-1,j)==true)
			return true;
		
		//left
		if(path(ar,i,j-1)==true)
			return true;
		
		//right
		if(path(ar,i,j+1)==true)
			return true;
		
		//down
		if(path(ar,i+1,j)==true)
			return true;
		
		ar[i][j]=0;  //backtracking
		
		return false;
	}
}