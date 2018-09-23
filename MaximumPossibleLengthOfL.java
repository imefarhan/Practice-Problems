package Personal;

//OPTIMISE it...TLE=106 secs
//Time to execute was 1 sec.

/*
INPUT::

8 5
. * * . *
. . * . *
. * * . .
. . * * *
* * * * *
. * . . .
. * . * *
. . * . .

*/

/* IMPORTANT: Multiple classes and nested static classes are supported */


//* uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class MaximumPossibleLengthOfL {
 
 static int memo[][] = new int[1000][1000];
 public static void main(String args[] ) throws Exception {

 InputReader in = new InputReader();
    
    int n = in.nextInt();
    int m = in.nextInt();
    
    char ar[][] = new char[n][m];
    
    for(int i=0; i<n; i++)
     for(int j=0; j<m; j++)
         ar[i][j] = in.next().charAt(0);
         
     function(ar,n,m);    
 }
 
 static void function(char ar[][], int n, int m)
 {
     int h=0, v=0, max=0;
     
     for(int i=n-2; i>0; i--)
     {
         for(int j=m-1; j>0; j--)
         {
             char ch = ar[i][j];
             
             if((ch=='.') && (possibleDirection(ar,i,j,n,m)==1) && memo[i][j]==0)
             {
                 int len =  maxLength(ar,i,j,n,m);
                 max = max > len ? max : len;
             }
         }
     }
     
     if(max>2)
     {
         System.out.println("YES");
         System.out.println(max);
     }
     else
         System.out.println("NO");
 }
 
 static int maxLength(char ar[][], int i, int j, int n, int m)
 {
     int h=0, v=0, len=1;
     while(i+1<n && j+1<m)
     {
         int x = possibleDirection(ar,i,j,n,m);
         if(x==1)
         {
             if(ar[i+1][j]=='.')
             {
                 h = 1;
                 memo[i+1][j]=1;
                 i++;
                 len++;
             }
             else if(ar[i][j+1]=='.')
             {
                 v = 1;
                 memo[i][j+1]=1;
                 j++;
                 len++;
             }
         }
         else
             break;
     }
     
     if(h>0 && v>0)
         return len;
     else
         return 0;
 }
 
 static int possibleDirection(char ar[][], int i, int j, int n, int m)
 {
     int res = 0;
     if(i+1<n && ar[i+1][j]=='.')
         res++;
     if(j+1<m && ar[i][j+1]=='.')
         res++;
     if(j-1>0 && ar[i][j-1]=='.')
         res++;
         
     return res;    
 }
 
 static class InputReader {

     BufferedReader br;
     StringTokenizer st;

     public InputReader() {
         br = new BufferedReader(new InputStreamReader(System.in));
     }

     String next() {
         while (st == null || !st.hasMoreElements()) {
             try {
                 st = new StringTokenizer(br.readLine());
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
         return st.nextToken();
     }

     int nextInt() {
         return Integer.parseInt(next());
     }

     long nextLong() {
         return Long.parseLong(next());
     }

     double nextDouble() {
         return Double.parseDouble(next());
     }

     String nextLine() {
         String str = "";
         try {
             str = br.readLine();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return str;
     }
 }
}
