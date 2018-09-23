package Personal;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SweetyCarSapient {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int ar[][] = new int[n][n];
 //     int a[][] = new int[n][n];
      
     for(int i=0; i<n; i++)
     {
       for(int j=0; j<n; j++)
       {
         ar[i][j] = sc.nextInt();
       }
     }
      
      
      ArrayList<Integer> al = new ArrayList<Integer>();
      for(int i=0; i<n; i++)
      {
    	  boolean flag = true;
        for(int j=0; j<n; j++)
        {
            if(ar[i][j] == 1 || ar[i][j]==3)
            {
              flag = false;
            }
        }
          if(flag)
          {
              al.add(i+1);
          }
        }
      
      System.out.println(al.size());
      Collections.sort(al);
      for(int x : al)
      {
    	  System.out.print(x+" ");
      }
      
    }
}